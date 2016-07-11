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
 * ����Spring ��junit���ϣ�junit����ʱ����SpringIOC����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")   //����junit Spring�����ļ�
public class SeckillDaoTest {

    //ע��Daoʵ��������
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
        //javaû�б����βεļ�¼��queryAll(int offset,int limit)--->queryAll(arg0,arg1) ��Ҫͨ��@Param����offset������ָ��
        List<Seckill> list = seckillDao.queryAll(0,3);
        for(Seckill sk:list) {
            System.out.println(sk);
        }
    }
}