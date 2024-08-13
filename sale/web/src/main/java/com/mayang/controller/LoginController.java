package com.mayang.controller;

import com.mayang.common.Result;
import com.mayang.params.UserLoginParam;
import com.mayang.params.UserRegisterParam;
import com.mayang.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping
@Api(value="LoginController", tags="用户登录")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value="用户登录")
    public Result<String> userLogin(@RequestBody UserLoginParam userLoginParam){
//        LoginUserInfoDTO loginUserInfoDTO = loginService.userLogin(userLoginParam);
//        if (Objects.nonNull(loginUserInfoDTO) && StringUtils.isNotBlank(loginUserInfoDTO.getAccessToken())) {
//            return Result.success(loginUserInfoDTO.getAccessToken());
//        }
        return Result.fail(Result.FAIL_CODE,"登录失败");
    }


    @PostMapping("/register")
    @ApiOperation(value="用户注册")
    public Result<Void> userRegister(@RequestBody UserRegisterParam userRegisterParam){
        try {
            loginService.userRegister(userRegisterParam.getPhoneNumber(), userRegisterParam.getVerificationCode());
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
        return Result.success();
    }

}
