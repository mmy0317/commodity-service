package com.mayang.util;

import java.util.UUID;

/**
 * 自动生成用户相关信息
 * @author mayang
 */
public class UserInfoUtil {

    public static String getUserCode(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public static String getNickName(){
        return "睿智的大表哥";
    }
}
