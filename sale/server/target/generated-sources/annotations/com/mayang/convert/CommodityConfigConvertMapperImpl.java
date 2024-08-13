package com.mayang.convert;

import com.mayang.entity.dos.CommodityConfigDO;
import com.mayang.entity.dto.CreateCommodityDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T21:30:37+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
public class CommodityConfigConvertMapperImpl implements CommodityConfigConvertMapper {

    @Override
    public CommodityConfigDO CommodityConfigDoConvertFromDto(CreateCommodityDTO createCommodityDTO) {
        if ( createCommodityDTO == null ) {
            return null;
        }

        CommodityConfigDO commodityConfigDO = new CommodityConfigDO();

        commodityConfigDO.setCommodityName( createCommodityDTO.getCommodityName() );
        commodityConfigDO.setCommodityPrice( createCommodityDTO.getCommodityPrice() );
        commodityConfigDO.setCommodityCount( createCommodityDTO.getCommodityCount() );

        return commodityConfigDO;
    }
}
