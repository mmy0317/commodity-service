package com.mayang.facade.users;

import com.mayang.dto.request.UserLoginDTO;
import com.mayang.dto.response.LoginUserInfoDTO;

public interface UserService {

    /**
     * 查询用户详情
     * @param userCode
     * @return
     */
    LoginUserInfoDTO getUserDetail(String userCode);


    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    LoginUserInfoDTO userLogin(UserLoginDTO userLoginDTO);
}
