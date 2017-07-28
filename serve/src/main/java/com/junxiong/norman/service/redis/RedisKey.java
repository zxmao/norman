package com.junxiong.norman.service.redis;

/**
 * @author zhangjunxiong
 * @since 2017/7/28
 */
public class RedisKey {
    public static final String USER="user:";
    public static final String USER_ID="user:id:";
    public static final String USER_TOKEN="user:token:";

    public static String getUserKey(Long id){
        return USER + id.toString();
    }
    public static String getUserIdKey(Long id){
        return USER_ID + id.toString();
    }
    public static String getUserTokenKey(String token){
        return USER_TOKEN + token;
    }
}
