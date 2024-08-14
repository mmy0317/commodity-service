package com.mayang.convert;

import com.mayang.entity.dos.UserDO;
import com.mayang.entity.dto.UserInfoDTO;
import com.mayang.entity.dto.UserLoginDTO;
import com.mayang.entity.params.UserLoginParam;
import com.mayang.entity.vo.LoginUserInfoVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T21:35:22+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
public class UserConvertMapperImpl implements UserConvertMapper {

    @Override
    public UserInfoDTO userDoToUserDto(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserInfoDTO userInfoDTO= new UserInfoDTO();

        userInfoDTO.setUserCode( userDO.getUserCode() );
        userInfoDTO.setPhoneNumber( userDO.getPhoneNumber() );
        userInfoDTO.setNickName( userDO.getNickName() );

        return userInfoDTO;
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
    public LoginUserInfoVO userDtoToUserVo(UserInfoDTO userInfoDTO) {
        if ( userInfoDTO == null ) {
            return null;
        }

        LoginUserInfoVO loginUserInfoVO = new LoginUserInfoVO();

        loginUserInfoVO.setUserCode( userInfoDTO.getUserCode() );
        loginUserInfoVO.setPhoneNumber( userInfoDTO.getPhoneNumber() );
        loginUserInfoVO.setNickName( userInfoDTO.getNickName() );
        loginUserInfoVO.setAccessToken( userInfoDTO.getAccessToken() );
        loginUserInfoVO.setRoleEnum( userInfoDTO.getRoleEnum() );

        return loginUserInfoVO;
    }
}
