package com.mayang.convert;

import com.mayang.entity.dos.CommodityDO;
import com.mayang.entity.dto.CreateCommodityDTO;
import com.mayang.entity.params.CreateCommodityParam;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T15:48:48+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
public class CommodityConfigConvertMapperImpl implements CommodityConfigConvertMapper {

    @Override
    public CommodityDO commodityConfigDoConvertFromDto(CreateCommodityDTO createCommodityDTO) {
        if ( createCommodityDTO == null ) {
            return null;
        }

        CommodityDO commodityDO = new CommodityDO();

        commodityDO.setCommodityName( createCommodityDTO.getCommodityName() );
        commodityDO.setCommodityPrice( createCommodityDTO.getCommodityPrice() );
        commodityDO.setCommodityCount( createCommodityDTO.getCommodityCount() );
        commodityDO.setCommodityPicture( createCommodityDTO.getCommodityPicture() );

        return commodityDO;
    }

    @Override
    public CreateCommodityDTO createCommodityDTOConvertFromParam(CreateCommodityParam createCommodityParam) {
        if ( createCommodityParam == null ) {
            return null;
        }

        CreateCommodityDTO createCommodityDTO = new CreateCommodityDTO();

        createCommodityDTO.setCommodityName( createCommodityParam.getCommodityName() );
        createCommodityDTO.setCommodityPrice( createCommodityParam.getCommodityPrice() );
        createCommodityDTO.setCommodityCount( createCommodityParam.getCommodityCount() );
        createCommodityDTO.setCommodityPicture( createCommodityParam.getCommodityPicture() );

        return createCommodityDTO;
    }
}
