package com.ttm.airbus.utils;

import java.security.MessageDigest;

/**
 * Created by liguoqing on 2016/9/13.
 */
public class PwdEncoder {

    private static final String[] hexHits = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private String salt; //盐值
    private String algorithm; //算法 MD5,SHA

    public PwdEncoder(){}

    public PwdEncoder(String salt,String algorithm){
        this.algorithm = algorithm;
        this.salt = salt;
    }

    public String encoder(String password){
        String result = null;
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            return byteArrayToHexString(md.digest(mergePasswordAndSalt(password).getBytes("UTF-8")));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private String mergePasswordAndSalt(String password) {
        if (password == null) {
            password = "";
        }
        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexHits[d1] + hexHits[d2];
    }


}
