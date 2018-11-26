package com.imooc.order.utils;

import java.util.Random;

/**
 * @Description: TODO
 * @Date: 2018/11/21
 */
public class keyUtils {

    /**
     * 生成唯一的主键
     */

    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
