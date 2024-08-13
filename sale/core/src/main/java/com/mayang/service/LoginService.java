package com.mayang.service;

import com.mayang.dto.LoginUserInfoDTO;
import com.mayang.enums.LoginType;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    /**
     * 校验token有效性
     * @param httpServletRequest
     */
    LoginUserInfoDTO checkToken(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 用户登录
     * @param phoneNumber 手机号
     * @param verificationCode 密码/验证码
     * @param loginType 登录类型
     * @return
     */
    LoginUserInfoDTO userLogin(String phoneNumber, String verificationCode, LoginType loginType);

    /**
     * 用户注册
     * @param phoneNumber
     * @param verificationCode
     * @return
     */
    void userRegister(String phoneNumber, String verificationCode);


}
