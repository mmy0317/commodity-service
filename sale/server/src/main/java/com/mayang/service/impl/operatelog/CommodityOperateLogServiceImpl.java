package com.mayang.service.impl.operatelog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayang.enums.CommodityOperateEnum;
import com.mayang.service.CommodityOperateLogService;
import org.springframework.stereotype.Service;


/**
 * 操作日志相关操作实现类
 * @author mayang
 */
@Service
public class CommodityOperateLogServiceImpl implements CommodityOperateLogService {


    @Override
    public void record(CommodityOperateEnum commodityOperateEnum, Object... detail) {
        String operateDetail = commodityOperateEnum.getOperateDetail();
//        operateDetail.
    }

    @Override
    public Page<?> searchRecords() {
        return null;
    }
}
