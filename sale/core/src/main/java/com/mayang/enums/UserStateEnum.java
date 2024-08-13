package com.mayang.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举
 * @author mayang
 */
@Getter
@AllArgsConstructor
public enum UserStateEnum {

    VALID(1,"有效"),

    INVALID(0,"注销")

    ;


    private Integer code;

    private String name;
}
