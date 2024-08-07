package com.mayang.dto.response;

import com.mayang.enums.RoleEnum;
import lombok.Data;

@Data
public class LoginUserInfoDTO {

    private String userCode;

    private String phoneNumber;

    private String nickName;

    private String accessToken;

    private RoleEnum roleEnum;

}
