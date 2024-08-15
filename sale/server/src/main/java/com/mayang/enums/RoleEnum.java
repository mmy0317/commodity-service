package com.mayang.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    CUSTOMER("customer","用户"),

    BUSINESS("business","业务人员"),

    ADMINISTRATOR("administrator","管理员")

    ;

    private String code;

    private String value;

    RoleEnum(String code, String value){

    }

}
