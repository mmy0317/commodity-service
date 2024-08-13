package com.mayang.entity.dto;

import com.mayang.entity.dto.PageCommonDTO;
import lombok.Data;

@Data
public class SearchCommodityDTO extends PageCommonDTO {
    //可以增加筛选条件

    /**
     * 商品状态
     */
    private Integer state;

}
