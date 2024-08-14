package com.mayang.controller;

import com.mayang.convert.UserConvertMapper;
import com.mayang.entity.dto.UserInfoDTO;
import com.mayang.entity.vo.LoginUserInfoVO;
import com.mayang.util.Result;
import com.mayang.entity.params.UserLoginParam;
import com.mayang.entity.params.UserRegisterParam;
import com.mayang.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
@Api(value="LoginController", tags="用户登录")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value="用户登录")
    public Result<LoginUserInfoVO> userLogin(@RequestBody UserLoginParam userLoginParam){
        UserInfoDTO userInfoDTO= loginService.userLogin(userLoginParam.getPhoneNumber(),
                userLoginParam.getVerificationCode(),userLoginParam.getLoginType());
        if (Objects.isNull(userInfoDTO) || StringUtils.isBlank(userInfoDTO.getAccessToken())) {
            return Result.fail(Result.FAIL_CODE, "登录失败");
        }
        LoginUserInfoVO loginUserInfoVO = UserConvertMapper.INSTANCE.userDtoToUserVo(userInfoDTO);
        return Result.success(loginUserInfoVO);
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
