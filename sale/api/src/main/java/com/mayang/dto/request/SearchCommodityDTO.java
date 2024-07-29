package com.mayang.dto.request;

import com.mayang.dto.PageCommonDTO;
import lombok.Data;

@Data
public class SearchCommodityDTO extends PageCommonDTO {
    //可以增加筛选条件

    /**
     * 商品状态
     */
    private Integer state;

}
