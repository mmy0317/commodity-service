package com.mayang.service;

import com.mayang.dto.response.LoginUserInfoDTO;
import com.mayang.params.UserLoginParam;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    /**
     * 校验token有效性
     * @param httpServletRequest
     */
    LoginUserInfoDTO checkToken(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 用户登录
     * @param userLoginParam
     * @return token
     */
    LoginUserInfoDTO userLogin(UserLoginParam userLoginParam);


}
