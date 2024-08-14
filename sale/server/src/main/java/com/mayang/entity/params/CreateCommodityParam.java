package com.mayang.entity.params;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 商品上架配置请求类
 * @author mayang
 */
@Data
public class CreateCommodityParam implements Serializable {

    /**
     * 商品名称
     */
    @NotBlank(message="商品名称不能为空")
    @ApiModelProperty(value="商品名称")
    private String commodityName;

    /**
     * 商品单价
     */
    @NotNull(message="商品单价不能为空")
    @ApiModelProperty(value="商品单价")
    private BigDecimal commodityPrice;

    /**
     * 商品库存数
     */
    @NotNull(message="商品库存数不能为空")
    @ApiModelProperty(value="商品库存数")
    private Integer commodityCount;

    /**
     * 商品示例图链接
     */
    @NotBlank(message="商品示例图链接不能为空")
    @ApiModelProperty(value="商品示例图链接")
    private String commodityPicture;
}
