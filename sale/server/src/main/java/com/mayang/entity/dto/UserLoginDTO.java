package com.mayang.entity.dto;

import com.mayang.enums.LoginType;
import lombok.Data;

@Data
public class UserLoginDTO {

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录类型
     */
    private LoginType loginType;

    /**
     * 手机短信验证码
     */
    private String verificationCode;


}
