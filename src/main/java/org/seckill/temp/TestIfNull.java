package org.seckill.temp;

import org.seckill.entity.Seckill;

/**
 * Created by xuery on 2016/6/29.
 */
public class TestIfNull {
    private static Seckill seckill;
    public static void main(String[] args){
        testMethod(seckill);
    }
    public static void testMethod(Seckill seckill){
        System.out.println(seckill.getName());
    }
}
