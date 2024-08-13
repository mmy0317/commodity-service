package com.mayang.controller;


import com.mayang.util.Result;
import com.mayang.entity.params.CreateCommodityParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/commodity/config")
@Api(value="CommodityConfigController", tags="商品信息管理")
public class CommodityConfigController {

    @PostMapping("/create")
    @ApiOperation(value="创建商品信息配置")
    public Result<Boolean> createCommodityConfig(@RequestBody CreateCommodityParam createCommodityParam){
        return Result.success();
    }

}
