package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Xuery on 2016/6/19.
 */
/**
 * Created by Xuery on 2016/6/19.
 * 配置Spring 和junit整合，junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")   //告诉junit Spring配置文件
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        int retVal = successKilledDao.insertSuccessKilled(1000L,5990L);
        System.out.println(retVal);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000L,5990L);
        System.out.println(successKilled);
    }
}