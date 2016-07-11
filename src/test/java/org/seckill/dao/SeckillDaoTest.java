package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Xuery on 2016/6/19.
 * 配置Spring 和junit整合，junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")   //告诉junit Spring配置文件
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        Date  date = new Date();
        int updateCount = seckillDao.reduceNumber(1000L,date);
        System.out.println(updateCount);
    }

    @Test
    public void testQueryById() throws Exception {
        long id=1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        //java没有保存形参的记录：queryAll(int offset,int limit)--->queryAll(arg0,arg1) 需要通过@Param（“offset”）来指明
        List<Seckill> list = seckillDao.queryAll(0,3);
        for(Seckill sk:list) {
            System.out.println(sk);
        }
    }
}