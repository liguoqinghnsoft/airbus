package com.ttm.airbus.utils;

import java.util.Random;

/**
 * Created by liguoqing on 2016/9/13.
 */
public class StringUtils {

    public static final String[] CHARS = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public static String getRandomString(int length){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++) {
            int seed = (int)(Math.random() * 26); //[0,1) + 25
            builder.append(CHARS[seed]);
        }
        return builder.toString();
    }

}
