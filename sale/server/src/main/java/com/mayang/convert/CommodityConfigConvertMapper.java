package com.mayang.convert;


import com.mayang.entity.dos.CommodityDO;
import com.mayang.entity.dto.CreateCommodityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommodityConfigConvertMapper {

    CommodityConfigConvertMapper INSTANCE = Mappers.getMapper(CommodityConfigConvertMapper.class);

    CommodityDO CommodityConfigDoConvertFromDto(CreateCommodityDTO createCommodityDTO);

}
