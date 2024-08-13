package com.mayang.convert;

import com.mayang.entity.dos.UserDO;
import com.mayang.entity.dto.LoginUserInfoDTO;
import com.mayang.entity.dto.UserLoginDTO;
import com.mayang.entity.params.UserLoginParam;
import com.mayang.entity.vo.LoginUserInfoVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T21:30:37+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
public class UserConvertMapperImpl implements UserConvertMapper {

    @Override
    public LoginUserInfoDTO userDoToUserDto(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        LoginUserInfoDTO loginUserInfoDTO = new LoginUserInfoDTO();

        loginUserInfoDTO.setUserCode( userDO.getUserCode() );
        loginUserInfoDTO.setPhoneNumber( userDO.getPhoneNumber() );
        loginUserInfoDTO.setNickName( userDO.getNickName() );

        return loginUserInfoDTO;
    }

    @Override
    public UserLoginDTO userLoginDTOConvertFromParam(UserLoginParam userLoginParam) {
        if ( userLoginParam == null ) {
            return null;
        }

        UserLoginDTO userLoginDTO = new UserLoginDTO();

        userLoginDTO.setPhoneNumber( userLoginParam.getPhoneNumber() );
        userLoginDTO.setPassword( userLoginParam.getPassword() );
        userLoginDTO.setLoginType( userLoginParam.getLoginType() );
        userLoginDTO.setVerificationCode( userLoginParam.getVerificationCode() );

        return userLoginDTO;
    }

    @Override
    public LoginUserInfoVO userDtoToUserVo(LoginUserInfoDTO loginUserInfoDTO) {
        if ( loginUserInfoDTO == null ) {
            return null;
        }

        LoginUserInfoVO loginUserInfoVO = new LoginUserInfoVO();

        loginUserInfoVO.setUserCode( loginUserInfoDTO.getUserCode() );
        loginUserInfoVO.setPhoneNumber( loginUserInfoDTO.getPhoneNumber() );
        loginUserInfoVO.setNickName( loginUserInfoDTO.getNickName() );
        loginUserInfoVO.setAccessToken( loginUserInfoDTO.getAccessToken() );
        loginUserInfoVO.setRoleEnum( loginUserInfoDTO.getRoleEnum() );

        return loginUserInfoVO;
    }
}
