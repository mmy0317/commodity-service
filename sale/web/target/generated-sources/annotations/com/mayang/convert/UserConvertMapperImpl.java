package com.mayang.convert;

import com.mayang.dto.UserLoginDTO;
import com.mayang.params.UserLoginParam;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T15:56:23+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
public class UserConvertMapperImpl implements UserConvertMapper {

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
}
