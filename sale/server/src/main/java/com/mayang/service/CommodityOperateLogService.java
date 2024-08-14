package com.mayang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayang.enums.CommodityOperateEnum;

/**
 * 商品操作日志相关操作接口
 * @author mayang
 */
public interface CommodityOperateLogService {

    /**
     * 记录操作日志
     */
    void record(CommodityOperateEnum commodityOperateEnum, Object... detail);

    /**
     * 查询操作日志(administrator权限8)
     * @return
     */
    Page<?> searchRecords();

}
