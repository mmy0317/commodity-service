package com.mayang.convert;


import com.mayang.dos.CommodityConfigDO;
import com.mayang.dto.CreateCommodityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommodityConfigConvertMapper {

    CommodityConfigConvertMapper INSTANCE = Mappers.getMapper(CommodityConfigConvertMapper.class);

    CommodityConfigDO CommodityConfigDoConvertFromDto(CreateCommodityDTO createCommodityDTO);

}
