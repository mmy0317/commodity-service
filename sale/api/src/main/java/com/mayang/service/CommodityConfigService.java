package com.mayang.service;

import com.mayang.common.Result;
import com.mayang.dto.request.CreateCommodityDTO;

/**
 * 商品信息配置请求接口
 * @author mayang
 */
public interface CommodityConfigService {

    /**
     * 新增商品配置(配置商品信息)
     * @return
     */
    Result<Void> createCommodityConfig(CreateCommodityDTO createCommodityDTO);

    /**
     * 商品配置上架
     * @return
     */
    Result<Void> shelfCommodityConfig();

    /**
     * 查询所有商品配置信息
     */

}
