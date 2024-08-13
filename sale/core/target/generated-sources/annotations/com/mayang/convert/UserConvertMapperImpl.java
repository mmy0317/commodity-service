package com.mayang.convert;

import com.mayang.dos.UserDO;
import com.mayang.dto.LoginUserInfoDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T15:56:19+0800",
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
}
