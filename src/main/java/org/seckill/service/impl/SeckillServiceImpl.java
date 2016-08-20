package org.seckill.service.impl;

import org.apache.commons.collections.MapUtils;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * SeckillService实现类
 * Created by xuery on 2016/6/27.
 */
@Service("seckillService")
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    //md5盐值字符串,用于混淆md5
    private final String slat = "sdasdghsagdgasdgasgdas##@#@#@&&&";


    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        //优点化：缓存优化,超时的基础上维护一致性
        /**
         * get from cache
         * if null
         *   get db
         * else
         *   put cache
         *locgoin
         *
         */
        //访问redis
        Seckill seckill = redisDao.getSeckill(seckillId);
        if(seckill==null){
            seckill = seckillDao.queryById(seckillId);
            if(seckill==null){
                return new Exposer(false,seckillId);
            }
            redisDao.putSeckill(seckill);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();

        Date nowTime = new Date();

        if(nowTime.getTime() <startTime.getTime() || nowTime.getTime() > endTime.getTime()){
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
        }
        //生成md5值
        String md5 = getMd5(seckillId);
        return new Exposer(true,md5,seckillId);
    }

    private String getMd5(long seckillId){
        String base = seckillId+"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    /**
     * 使用注解控制事务的优点:
     * 1.开发团队达成一致约定,明确标注事务方法的编程风格.
     * 2.保证事务方法的执行时间尽可能短,不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部.
     * 3.不是所有的方法都需要事务.如一些查询的service.只有一条修改操作的service.
	 *这个很关键，事务处理
     */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if(md5 == null || !getMd5(seckillId).equals(md5)){
            throw new SeckillException("seckill date rewrite");
        }
        //执行秒杀逻辑:1.减库存.2.记录购买行为
        Date nowTime = new Date();

        try {
            //出入秒杀成功记录
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            //seckillId,userPhone
            if (insertCount <= 0) {
                //重复秒杀
                throw new RepeatKillException("seckill repeated");
            }
            else {
                //记录购买行为 商品竞争
                int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
                if (updateCount <= 0) {
                    //秒杀结束
                    throw new SeckillCloseException("seckill is closed");
                }
                else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        }catch(SeckillCloseException e1){
            throw e1;
        }
        catch(RepeatKillException e2){
            throw e2;
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            //所有的编译期异常转化为运行期异常,spring的声明式事务做rollback
            throw new SeckillException("seckill inner error"+e.getMessage());
        }

    }

    public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) {
        if(md5 == null || !getMd5(seckillId).equals(md5) ){
            return new SeckillExecution(seckillId,SeckillStatEnum.DATA_REWRITE);
        }
        Date killTime = new Date();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("seckillId",seckillId);
        map.put("phone",userPhone);
        map.put("killTime",killTime);
        map.put("result",null);

        //执行存储过程，result被复制
        try {
            seckillDao.killByProcedure(map);
            //获取result
            int result = MapUtils.getInteger(map,"result",-2);
            if(result == 1){
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
                return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,successKilled);
            }
            else{
                return new SeckillExecution(seckillId,SeckillStatEnum.stateOf(result));
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            return new SeckillExecution(seckillId,SeckillStatEnum.INNER_ERROR);
        }
    }
}
