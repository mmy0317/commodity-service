package com.mayang.convert;

import com.mayang.entity.dos.CommodityDO;
import com.mayang.entity.dto.CreateCommodityDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T21:35:22+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
public class CommodityConfigConvertMapperImpl implements CommodityConfigConvertMapper {

    @Override
    public CommodityDO CommodityConfigDoConvertFromDto(CreateCommodityDTO createCommodityDTO) {
        if ( createCommodityDTO == null ) {
            return null;
        }

        CommodityDO commodityDO= new CommodityDO();

        commodityDO.setCommodityName( createCommodityDTO.getCommodityName() );
        commodityDO.setCommodityPrice( createCommodityDTO.getCommodityPrice() );
        commodityDO.setCommodityCount( createCommodityDTO.getCommodityCount() );

        return commodityDO;
    }
}
