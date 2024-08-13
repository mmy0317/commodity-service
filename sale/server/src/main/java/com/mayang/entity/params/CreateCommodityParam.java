package com.mayang.entity.params;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 商品上架配置请求类
 * @author mayang
 */
@Data
public class CreateCommodityParam implements Serializable {

    /**
     * 商品名称
     */
    @ApiModelProperty(value="商品名称")
    private String commodityName;

    /**
     * 商品单价
     */
    @ApiModelProperty(value="商品单价")
    private Long commodityPrice;

    /**
     * 商品库存数
     */
    @ApiModelProperty(value="商品库存数")
    private Integer commodityCount;
}
