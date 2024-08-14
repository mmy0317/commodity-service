package com.mayang.service.impl.commodity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayang.entity.dos.CommodityDO;
import com.mayang.enums.CommodityOperateEnum;
import com.mayang.util.Result;
import com.mayang.entity.dto.CreateCommodityDTO;
import com.mayang.entity.dto.SearchCommodityDTO;
import com.mayang.entity.dto.ShelfCommodityDTO;
import com.mayang.mapper.CommodityMapper;
import com.mayang.service.CommodityConfigService;
import com.mayang.service.CommodityOperateLogService;
import com.mayang.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 商品处理
 * @author mayang
 */

@Service
@Slf4j
public class CommodityConfigServiceImpl implements CommodityConfigService {

    @Resource
    private CommodityMapper commodityMapper;

    @Resource
    private CommodityOperateLogService commodityOperateLogService;

    @Override
    public void createCommodityConfig(CreateCommodityDTO createCommodityDTO) {
        //step1 数据校验, todo 权限校验
        commodityConfigCheck(createCommodityDTO.getCommodityName(),createCommodityDTO.getCommodityPrice(),createCommodityDTO.getCommodityCount());
        //step2 数据转换,数据存储
        CommodityDO commodityDO = new CommodityDO();
        commodityDO.createCommodity(createCommodityDTO);
        commodityMapper.insert(commodityDO);
        //step3 记录操作日志
        String operateDetail = StringUtil.replaceByArrays(
                CommodityOperateEnum.CREATE.getOperateDetail(),
                "\\{\\}",
                commodityDO.getId(),
                commodityDO.getCommodityName(),
                commodityDO.getCommodityPrice(),
                commodityDO.getCommodityCount(),
                commodityDO.getCommodityPicture()
        );
        commodityOperateLogService.record(CommodityOperateEnum.CREATE, commodityDO.getId(), operateDetail);
    }

    private void commodityConfigCheck(String name, BigDecimal price, Integer count){
        if (StringUtils.isBlank(name) || name.replaceAll("\\s", "").length() <= 3){
            throw new RuntimeException("商品名称不能为空或商品小于等于3个字, 请修改。");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("商品价格不能小于等于0元, 请修改。");
        }
        if (count < 0){
            throw new RuntimeException("商品库存量不能小于0, 请修改。");
        }
    }

    @Override
    public Result<Void> shelfCommodityConfig(ShelfCommodityDTO shelfCommodityDTO) {
        return null;
    }

    @Override
    public Result<Page<?>> queryConfigPage(SearchCommodityDTO dto) {
        //step1 数据查询
        QueryWrapper<CommodityDO> commodityConfigDOQueryWrapper = new QueryWrapper<>();
        commodityConfigDOQueryWrapper.eq(Objects.nonNull(dto.getState()),"state",dto.getState());
        Page<CommodityDO> commodityConfigDOPage = new Page<>(dto.getPage(),dto.getSize());
        IPage<CommodityDO> commodityConfigDOIPage = commodityMapper.selectPage(commodityConfigDOPage,commodityConfigDOQueryWrapper);
        if (Objects.isNull(commodityConfigDOIPage) || CollectionUtils.isEmpty(commodityConfigDOIPage.getRecords())){
            return Result.success(commodityConfigDOPage);
        }
        commodityConfigDOPage.setRecords(commodityConfigDOIPage.getRecords());
        commodityConfigDOIPage.setTotal(commodityConfigDOIPage.getTotal());
        return Result.success(commodityConfigDOPage);
    }
}
