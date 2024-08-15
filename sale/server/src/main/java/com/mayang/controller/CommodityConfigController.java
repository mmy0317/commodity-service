package com.mayang.controller;


import com.mayang.convert.CommodityConfigConvertMapper;
import com.mayang.entity.UserContext;
import com.mayang.entity.dto.CreateCommodityDTO;
import com.mayang.entity.dto.UserInfoDTO;
import com.mayang.service.CommodityConfigService;
import com.mayang.util.Result;
import com.mayang.entity.params.CreateCommodityParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/commodity/config")
@Api(value="CommodityConfigController", tags="商品信息管理")
public class CommodityConfigController {

    @Resource
    private CommodityConfigService commodityConfigService;

    @PostMapping("/create")
    @ApiOperation(value="创建商品信息配置")
    public Result<Boolean> createCommodityConfig(@RequestBody CreateCommodityParam createCommodityParam){
        CreateCommodityDTO createCommodityDTO = CommodityConfigConvertMapper.INSTANCE.createCommodityDTOConvertFromParam(createCommodityParam);
        commodityConfigService.createCommodityConfig(createCommodityDTO);
        return Result.success();
    }

    @PostMapping("/delete")
    @ApiOperation(value="删除商品信息配置")
    public Result<Boolean> deleteCommodityConfig(@RequestBody CreateCommodityParam createCommodityParam){
        return Result.success();
    }

    @PostMapping("/update")
    @ApiOperation(value="更新商品信息配置")
    public Result<Boolean> updateCommodityConfig(@RequestBody CreateCommodityParam createCommodityParam){
        return Result.success();
    }

    @PostMapping("/search")
    @ApiOperation(value="查询商品信息配置")
    public Result<Boolean> searchCommodityConfig(@RequestBody CreateCommodityParam createCommodityParam){
        return Result.success();
    }

}
