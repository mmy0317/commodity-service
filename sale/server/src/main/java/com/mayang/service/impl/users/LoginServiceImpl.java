package com.mayang.service.impl.users;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayang.entity.dos.UserDO;
import com.mayang.entity.dto.UserInfoDTO;
import com.mayang.util.JWTUtil;
import com.mayang.convert.UserConvertMapper;
import com.mayang.enums.LoginType;
import com.mayang.enums.UserStateEnum;
import com.mayang.mapper.UserMapper;
import com.mayang.service.LoginService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Value("${user.login.special.code}")
    private String SPECIAL_USER_CODE;

    private final String SECURITY_TOKEN = "_security_token";

    private final Long TIME_OUT_MINUTES = 12 * 60L;

    private final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    @Resource
    private UserMapper userMapper;

    /**
     * token有效性校验
     * @param httpServletRequest
     * @return
     */
    @Override
    public UserInfoDTO checkToken(HttpServletRequest httpServletRequest) throws Exception{
        //step1 token存在性校验, 不存在token直接返回
        String token = httpServletRequest.getHeader(SECURITY_TOKEN);
        if (StringUtils.isBlank(token)){
            throw new RuntimeException("token为空");
        }
        //Step2 token有效性校验
        Claims claims = JWTUtil.parseJWT(token);
        String userCode = claims.getSubject();
        Date expirationDate = claims.getExpiration();
//        Date issueDate = claims.getIssuedAt(); //签发时间
        Date nowDate = new Date();
        if (nowDate.after(expirationDate)) {
            throw new RuntimeException("token已过期");
        }
        //step3 查询用户信息
        QueryWrapper<UserDO> userDOQueryWrapper = new QueryWrapper<>();
        userDOQueryWrapper.eq("user_code",userCode);
        UserDO userDO = userMapper.selectOne(userDOQueryWrapper);
        if (Objects.isNull(userDO)){
            throw new RuntimeException("用户不存在或已经注销。");
        }
        if (UserStateEnum.INVALID.getCode().equals(userDO.getState())){
            throw new RuntimeException("该用户已注销。");
        }
        log.info("{}, 用户{}, 登录成功。", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), userDO.getUserCode());
        return UserConvertMapper.INSTANCE.userDoToUserDto(userDO);
    }

    @Override
    public UserInfoDTO userLogin(String phoneNumber, String verificationCode, LoginType loginType) {
        log.info("用户登录信息:{},{},{}", phoneNumber, verificationCode, loginType.name());
        //step1 校验用户详细信息
        QueryWrapper<UserDO> userDOQueryWrapper = new QueryWrapper<>();
        userDOQueryWrapper.eq("phone_number", phoneNumber);
        userDOQueryWrapper.eq("state",UserStateEnum.VALID.getCode());
        UserDO userDO = userMapper.selectOne(userDOQueryWrapper);
        if (Objects.isNull(userDO)){
            throw new RuntimeException("该手机号未注册或已注销。");
        }
        if (LoginType.PASSWORD.equals(loginType)){
            passwordLoginCheck(phoneNumber, verificationCode);
        }else if (LoginType.VERIFICATION_CODE.equals(loginType)){
            verificationCodeLogin(phoneNumber, verificationCode);
        }
        //生成token
        String accessToken = JWTUtil.createJWT(userDO.getUserCode());
        UserInfoDTO userInfoDTO= UserConvertMapper.INSTANCE.userDoToUserDto(userDO);
        userInfoDTO.setAccessToken(accessToken);
        return userInfoDTO;
    }

    private void passwordLoginCheck(String phoneNumber,String password){

    }

    private void verificationCodeLogin(String phoneNumber,String verificationCode){

    }

    @Override
    public void userRegister(String phoneNumber, String verificationCode) {
        //step1 手机号校验
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone_number",phoneNumber);
        queryWrapper.eq("state", UserStateEnum.VALID.getCode());
        List<UserDO> userDOList = userMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(userDOList)){
            throw new RuntimeException("当前手机号已被注册。");
        }
        //step2 手机短信验证码校验
        if (StringUtils.isBlank(verificationCode)){
            throw new RuntimeException("请输入正确的验证码。");
        }
        //ste3 用户注册
        UserDO userDO = new UserDO();
        userDO.register(phoneNumber);
        try {
            userMapper.insert(userDO);
        }catch (Exception e){
            log.error("用户注册发生异常, 数据库插入信息:{}, 异常原因:{}", JSONObject.toJSON(userDO),e.getMessage());
            throw new RuntimeException("系统繁忙, 请稍后再试");
        }
    }


}
