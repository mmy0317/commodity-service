package com.mayang.entity.params;


import lombok.Data;

/**
 * 用户注册实体
 */
@Data
public class UserRegisterParam {

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 手机验证码
     */
    private String verificationCode;

}
