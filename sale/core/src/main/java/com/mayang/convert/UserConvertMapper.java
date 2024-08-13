package com.mayang.convert;


import com.mayang.dos.UserDO;
import com.mayang.dto.LoginUserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvertMapper {

    UserConvertMapper INSTANCE = Mappers.getMapper(UserConvertMapper.class);

    LoginUserInfoDTO userDoToUserDto(UserDO userDO);
}
