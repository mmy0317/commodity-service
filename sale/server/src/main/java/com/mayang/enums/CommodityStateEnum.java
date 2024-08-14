package com.mayang.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommodityStateEnum {

    ORIGINAL(0, "未上架"),

    SALE(10,"已上架"),

    DELETE(20,"已删除")

    ;

    private Integer code;

    private String value;

}
