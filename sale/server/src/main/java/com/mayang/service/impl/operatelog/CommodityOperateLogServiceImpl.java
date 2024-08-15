package com.mayang.service.impl.operatelog;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mayang.entity.UserContext;
import com.mayang.entity.dos.CommodityOperateLogDO;
import com.mayang.entity.dto.UserInfoDTO;
import com.mayang.enums.CommodityOperateEnum;
import com.mayang.mapper.CommodityOperateLogMapper;
import com.mayang.service.CommodityOperateLogService;
import com.mayang.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 操作日志相关操作实现类
 * @author mayang
 */
@Service
public class CommodityOperateLogServiceImpl implements CommodityOperateLogService {

    @Resource
    private CommodityOperateLogMapper commodityOperateLogMapper;


    @Override
    public void record(CommodityOperateEnum commodityOperateEnum, Long commodityId, String detail) {
        UserInfoDTO userInfoDTO = UserContext.getUserInfoDto();
        CommodityOperateLogDO commodityOperateLogDO = new CommodityOperateLogDO();
        commodityOperateLogDO.setCommodityId(commodityId);
        commodityOperateLogDO.setOperateUserCode(userInfoDTO.getUserCode());
        commodityOperateLogDO.setOperateUserName(userInfoDTO.getNickName());
        commodityOperateLogDO.setOperateDetail(detail);
        commodityOperateLogDO.setCreateTime(LocalDateTime.now());
        commodityOperateLogMapper.insert(commodityOperateLogDO);
    }

    @Override
    public Page<?> searchRecords() {
        return null;
    }
}
