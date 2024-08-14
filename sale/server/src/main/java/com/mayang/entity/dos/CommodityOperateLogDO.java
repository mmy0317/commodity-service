package com.mayang.entity.dos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("commodity_operate_logs")
public class CommodityOperateLogDO {

    @TableId
    private Long id;

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * 操作人code
     */
    private String operateUserCode;

    /**
     * 操作人名称
     */
    private String operateUserName;

    /**
     * 操作详情
     */
    private String operateDetail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    /**
     * CREATE TABLE `commodity_operate_logs` (
     *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
     *   `commodity_id` bigint(20) NOT NULL COMMENT '商品id',
     *   `operate_user_code` varchar(32) NOT NULL COMMENT '操作人code',
     *   `operate_user_name` varchar(32) NOT NULL COMMENT '操作人name',
     *   `operate_detail` varchar(32) NOT NULL COMMENT '操作详情',
     *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     *   PRIMARY KEY (`id`),
     *   KEY `idx_create_time` (`create_time`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品操作日志记录表';
     */

}
