package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 *SeckillService测试类
 * Created by xuery on 2016/6/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
            "classpath:spring/spring-dao.xml",
            "classpath:spring/spring-service.xml"
            })   //告诉junit Spring配置文件
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void testGetById() throws Exception {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        Exposer exposer = seckillService.exportSeckillUrl(1001);
        logger.info("exposer={}", exposer);
        /**
         * 秒杀时间不对
         *Exposer{exposed=false, md5='null', seckillId=1001, now=1467028509100, start=1446307200000, end=1446393600000}
         *
         * 秒杀时间对
         * Exposer{exposed=true, md5='ebbec078d02261e258c4af348089ca90', seckillId=1001, now=0, start=0, end=0}
         * */
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        String md5 = "ebbec078d02261e258c4af348089ca90";
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(1001, 1511795599, md5);
            logger.info("seckillExecution={}",seckillExecution);
        }catch(SeckillCloseException e){
            logger.error(e.getMessage());
        }catch(RepeatKillException e){
            logger.error(e.getMessage());
        }catch(SeckillException e){
            logger.error(e.getMessage());
        }

    }
}