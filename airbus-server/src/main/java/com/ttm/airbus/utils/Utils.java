package com.ttm.airbus.utils;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

/**
 * Created by liguoqing on 2016/9/13.
 */
public class Utils {

    private Utils() {
    }

    public static final String[] CHARS = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String getRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int seed = (int) (Math.random() * 26); //[0,1) + 25
            builder.append(CHARS[seed]);
        }
        return builder.toString();
    }

    public static Map<String, Object> filterRequestUrl(String url) {
        if (StringUtils.isEmpty(url) || url.indexOf("?") <= 0) {
            return Collections.emptyMap();
        }
        Map<String, Object> kvs = Maps.newLinkedHashMap();
        Arrays.asList(url.split("&")).stream().forEach(kv -> {
            String[] str = kv.split("=");
            kvs.put(str[0], str[1]);
        });
        return kvs;
    }

}
