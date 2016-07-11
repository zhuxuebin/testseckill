package test.org.seckill.dao.cache;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * RedisDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 11, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class RedisDaoTest {
    private long id=1001;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    @Before
    public void before() throws Exception {
        System.out.println("here we go!!");
    }

    @After
    public void after() throws Exception {
        System.out.println("in the end");
    }

    /**
     * Method: getSeckill(long seckillId)
     */
    @Test
    public void testSeckill() throws Exception {
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillDao.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);
                seckill = redisDao.getSeckill(id);
                System.out.println(seckill);
            }
        }
    }

} 
