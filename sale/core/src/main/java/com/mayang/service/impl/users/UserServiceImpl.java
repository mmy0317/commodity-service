package com.mayang.service.impl.users;

import com.mayang.dto.request.UserLoginDTO;
import com.mayang.dto.response.LoginUserInfoDTO;
import com.mayang.facade.users.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息类
 * @author mayang
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public LoginUserInfoDTO getUserDetail(String userCode) {
        return null;
    }

    @Override
    public LoginUserInfoDTO userLogin(UserLoginDTO userLoginDTO) {
        return null;
    }
}
