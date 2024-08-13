package com.mayang.convert;


import com.mayang.dto.UserLoginDTO;
import com.mayang.params.UserLoginParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvertMapper {

    UserConvertMapper INSTANCE = Mappers.getMapper(UserConvertMapper.class);

    UserLoginDTO userLoginDTOConvertFromParam(UserLoginParam userLoginParam);


}
