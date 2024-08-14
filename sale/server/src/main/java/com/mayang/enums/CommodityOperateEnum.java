package com.mayang.enums;

import lombok.Getter;

/**
 * 商品操作日志枚举
 */

@Getter
public enum CommodityOperateEnum {

    CREATE("创建商品信息 商品id:{}, 商品名称:{}, 商品单价:{}, 商品库存:{}, 商品示例图片:{}")

    ;

    private String operateDetail;

    CommodityOperateEnum(String operateDetail){
        this.operateDetail = operateDetail;
    }
}
