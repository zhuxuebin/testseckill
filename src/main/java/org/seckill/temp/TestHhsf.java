package org.seckill.temp;

import org.seckill.entity.Seckill;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;

/**
 * Created by xuery on 2016/7/9.
 */
public class TestHhsf {
    public static void main(String[] args){
        String s = "1232.00";
        DecimalFormat  decimalFormat = new DecimalFormat("0");
        System.out.println(subZeroAndDot(s));
        //System.out.println(decimalFormat.format(s));
        System.out.println(isNum(s));

        Seckill seckill = new Seckill();
        seckill.setName("   zzz   ");
        seckill.setName(seckill.getName().trim());
        System.out.println(seckill.getName());
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public static boolean isNum(String str) {

        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
