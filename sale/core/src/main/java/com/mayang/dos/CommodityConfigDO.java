package com.mayang.dos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("commodity_config")
public class CommodityConfigDO implements Serializable {

    @TableId
    private Long id;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

    /**
     * 商品状态
     */
    private Integer state;

}
