package com.mayang.convert;


import com.mayang.entity.dos.CommodityDO;
import com.mayang.entity.dto.CreateCommodityDTO;
import com.mayang.entity.params.CreateCommodityParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommodityConfigConvertMapper {

    CommodityConfigConvertMapper INSTANCE = Mappers.getMapper(CommodityConfigConvertMapper.class);

    CommodityDO commodityConfigDoConvertFromDto(CreateCommodityDTO createCommodityDTO);

    CreateCommodityDTO createCommodityDTOConvertFromParam(CreateCommodityParam createCommodityParam);


}
