package com.mayang.params;

import com.mayang.enums.LoginType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserLoginParam {

    /**
     * 手机号
     */
    @NotBlank(message="手机号不能为空")
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录类型
     */
    @NotNull(message="登录类型不能为空")
    private LoginType loginType;

    /**
     * 手机短信验证码
     */
    private String verificationCode;


}
