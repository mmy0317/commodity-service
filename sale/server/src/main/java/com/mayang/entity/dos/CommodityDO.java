package com.mayang.entity.dos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mayang.entity.dto.CreateCommodityDTO;
import com.mayang.enums.CommodityStateEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("commodities")
public class CommodityDO implements Serializable {

    @TableId
    private Long id;

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
     * 商品图片
     */
    private String commodityPicture;

    /**
     * 商品状态
     */
    private Integer commodityState;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    public void createCommodity(CreateCommodityDTO createCommodityDTO){
        this.commodityName = createCommodityDTO.getCommodityName();
        this.commodityPrice = createCommodityDTO.getCommodityPrice();
        this.commodityCount = createCommodityDTO.getCommodityCount();
        this.commodityPicture = createCommodityDTO.getCommodityPicture();
        this.commodityState =CommodityStateEnum.ORIGINAL.getCode();
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

}
