package com.mayang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayang.util.Result;
import com.mayang.entity.dto.CreateCommodityDTO;
import com.mayang.entity.dto.SearchCommodityDTO;
import com.mayang.entity.dto.ShelfCommodityDTO;

/**
 * 商品信息配置请求接口
 * @author mayang
 */
public interface CommodityConfigService {

    /**
     * 新增商品配置(配置商品信息)
     * @return
     */
    void createCommodityConfig(CreateCommodityDTO createCommodityDTO);

    /**
     * 商品配置上架
     * @return
     */
    Result<Void> shelfCommodityConfig(ShelfCommodityDTO shelfCommodityDTO);

    /**
     * 查询所有商品配置信息
     */
    Result<Page<?>> queryConfigPage(SearchCommodityDTO searchCommodityDTO);
}
