package com.mayang.service.impl;

import com.mayang.common.Result;
import com.mayang.convert.CommodityConfigConvertMapper;
import com.mayang.dos.CommodityConfigDO;
import com.mayang.dto.request.CreateCommodityDTO;
import com.mayang.enums.CommodityStateEnum;
import com.mayang.mapper.CommodityConfigMapper;
import com.mayang.service.CommodityConfigService;
import com.mayang.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 商品处理
 * @author mayang
 */

@Service
@Slf4j
public class CommodityConfigServiceImpl implements CommodityConfigService {

    @Resource
    private CommodityConfigMapper commodityConfigMapper;

    @Resource
    private OperateLogService operateLogService;

    @Override
    public Result<Void> createCommodityConfig(CreateCommodityDTO createCommodityDTO) {
        //step1 数据校验(什么商品名称不存在特殊字符, 什么价格必须xx, 库存数必须大于0)
        //step2 数据转换
        CommodityConfigDO commodityConfigDO = CommodityConfigConvertMapper.INSTANCE.CommodityConfigDoConvertFromDto(createCommodityDTO);
        commodityConfigDO.setCreateTime(LocalDateTime.now());
        commodityConfigDO.setState(CommodityStateEnum.ORIGINAL.getCode());
        //step3 数据存储
        commodityConfigMapper.insert(commodityConfigDO);
        //step4 记录操作日志
        operateLogService.record();
        return Result.success();
    }

    @Override
    public Result<Void> shelfCommodityConfig() {
        return null;
    }
}
