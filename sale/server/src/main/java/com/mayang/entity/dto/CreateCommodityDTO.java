package com.mayang.entity.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


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
    private BigDecimal commodityPrice;

    /**
     * 商品库存数
     */
    private Integer commodityCount;

    /**
     * 商品示例图
     */
    private String commodityPicture;

}
