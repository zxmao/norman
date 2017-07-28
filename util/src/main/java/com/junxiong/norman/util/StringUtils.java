package com.junxiong.norman.util;

import java.util.Random;

/**
 * @author zhangjunxiong
 * @since 2017/7/28
 */
public class StringUtils {

    /**随机字符*/
    public static final char[] charArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    /**
     * 生成给定长度的随机数
     */
    public static String getRandomString(int length){
        Random random = new Random();
        char[] newCharArr = new char[length];
        for (int i = 0; i < newCharArr.length; i++) {
            newCharArr[i] = charArr[random.nextInt(charArr.length)];
        }
        return new String(newCharArr);
    }
}
