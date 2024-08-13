package com.mayang.convert;


import com.mayang.entity.dos.UserDO;
import com.mayang.entity.dto.LoginUserInfoDTO;
import com.mayang.entity.dto.UserLoginDTO;
import com.mayang.entity.params.UserLoginParam;
import com.mayang.entity.vo.LoginUserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvertMapper {

    UserConvertMapper INSTANCE = Mappers.getMapper(UserConvertMapper.class);

    LoginUserInfoDTO userDoToUserDto(UserDO userDO);

    UserLoginDTO userLoginDTOConvertFromParam(UserLoginParam userLoginParam);

    LoginUserInfoVO userDtoToUserVo(LoginUserInfoDTO loginUserInfoDTO);
}
