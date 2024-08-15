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

    /**
     * CREATE TABLE `commodities` (
     *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
     *   `commodity_name` varchar(32) NOT NULL COMMENT '商品名称',
     *   `commodity_price` decimal(12,4) NOT NULL COMMENT '商品价格',
     *   `commodity_count` bigint(20) NOT NULL COMMENT '商品库存数',
     *   `commodity_picture` varchar(256) NOT NULL COMMENT '商品示例图链接',
     *   `commodity_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '商品商品状态 0-未上架 1-已上架 2-删除',
     *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     *   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
     *   PRIMARY KEY (`id`),
     *   KEY `idx_commodity_price` (`commodity_price`),
     *   KEY `idx_commodity_state` (`commodity_state`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';
     */

}
