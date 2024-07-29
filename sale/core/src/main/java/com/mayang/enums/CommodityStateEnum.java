package com.mayang.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommodityStateEnum {

    ORIGINAL(0, "初始状态"),

    SALE(10,"已上架"),

    DELETE(20,"已下架")

    ;

    private Integer code;

    private String value;

}
