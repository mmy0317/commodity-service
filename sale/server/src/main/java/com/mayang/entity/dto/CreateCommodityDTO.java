package com.mayang.entity.dto;


import lombok.Data;

import java.io.Serializable;


/**
 * 商品上架配置请求类
 * @author mayang
 */
@Data
public class CreateCommodityDTO implements Serializable {

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品单价
     */
    private Long commodityPrice;

    /**
     * 商品库存数
     */
    private Integer commodityCount;
}
