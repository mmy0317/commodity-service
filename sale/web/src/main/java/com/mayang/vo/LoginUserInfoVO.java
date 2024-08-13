package com.mayang.vo;

import com.mayang.enums.RoleEnum;
import lombok.Data;

@Data
public class LoginUserInfoVO {

    private String userCode;

    private String phoneNumber;

    private String nickName;

    private String accessToken;

    private RoleEnum roleEnum;

}
