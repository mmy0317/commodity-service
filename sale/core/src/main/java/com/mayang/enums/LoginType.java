package com.mayang.enums;

public enum LoginType {

    PASSWORD("手机号,密码登录"),

    VERIFICATION_CODE("手机验证码登录"),

    ;

    private String value;

    LoginType(String value){
        this.value = value;
    }


}
