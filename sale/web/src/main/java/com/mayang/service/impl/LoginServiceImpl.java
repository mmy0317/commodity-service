package com.mayang.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.mayang.convert.UserConvertMapper;
import com.mayang.dto.request.UserLoginDTO;
import com.mayang.dto.response.LoginUserInfoDTO;
import com.mayang.facade.users.UserService;
import com.mayang.params.UserLoginParam;
import com.mayang.service.JWTUtil;
import com.mayang.service.LoginService;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final String SECURITY_TOKEN = "_security_token";

    private final Long TIME_OUT_MINUTES = 12 * 60L;

    private final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    @Resource
    private UserService userService;

    /**
     * token有效性校验
     * @param httpServletRequest
     * @return
     */
    @Override
    public LoginUserInfoDTO checkToken(HttpServletRequest httpServletRequest) throws Exception{
        String token = httpServletRequest.getHeader(SECURITY_TOKEN);
        if (StringUtils.isBlank(token)){
            throw new RuntimeException("token为空");
        }
        Claims claims = JWTUtil.parseJWT(token);
//        //uuid
//        String id = claims.getId();
//        //subject
//        String subject = claims.getSubject();
//        //签发时间
//        Date issueDate = claims.getIssuedAt();
        //过期时间
        Date expirationDate = claims.getExpiration();
        //当前时间
        Date nowDate = new Date();
        if (nowDate.after(expirationDate)) {
            throw new RuntimeException("token已过期");
        }
        //查询用户详细信息
        LoginUserInfoDTO loginUserInfoDTO = userService.getUserDetail(claims.getSubject());
        if (Objects.isNull(loginUserInfoDTO)){
            log.error("用户:{}不存在, 登录失败",claims.getSubject());
        }
        return null;
    }

    @Override
    public LoginUserInfoDTO userLogin(UserLoginParam userLoginParam) {
        log.info("用户登录信息:{}", JSONObject.toJSONString(userLoginParam));
        //校验用户详细信息
        UserLoginDTO userLoginDTO = UserConvertMapper.INSTANCE.userLoginDTOConvertFromParam(userLoginParam);
        LoginUserInfoDTO loginUserInfoDTO;
        try {
            loginUserInfoDTO = userService.userLogin(userLoginDTO);
        }catch (RuntimeException e){
            log.error("用户登录手机号:{}, 登录失败, 失败原因:{}",userLoginParam.getPhoneNumber(),e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        //生成token
        String accessToken = JWTUtil.createJWT(loginUserInfoDTO.getUserCode());
        loginUserInfoDTO.setAccessToken(accessToken);
        return loginUserInfoDTO;
    }



}
