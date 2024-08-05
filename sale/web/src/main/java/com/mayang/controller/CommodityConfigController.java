package com.mayang.controller;


import com.mayang.common.Result;
import com.mayang.dto.request.CreateCommodityDTO;
import com.mayang.facade.commodity.CommodityConfigService;
import com.mayang.params.CreateCommodityParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@Slf4j
@RequestMapping("/commodity/config")
@Api(value="CommodityConfigController", tags="商品信息管理")
public class CommodityConfigController {

    @Resource
    private CommodityConfigService commodityConfigService;


    @PostMapping("/create")
    @ApiOperation(value="创建商品信息配置")
    public Result<Boolean> createCommodityConfig(@RequestBody CreateCommodityParam createCommodityParam){
        CreateCommodityDTO createCommodityDTO = new CreateCommodityDTO();
        try {
            commodityConfigService.createCommodityConfig(createCommodityDTO);
        }catch (Exception e){
            log.info("创建商品信息异常, 异常原因:{}", e.getMessage());
            return Result.fail(Result.FAIL_CODE, e.getMessage());
        }
        return Result.success(Boolean.TRUE);
    }

}
