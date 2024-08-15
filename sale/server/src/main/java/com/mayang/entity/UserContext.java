package com.mayang.entity;


import com.mayang.entity.dto.UserInfoDTO;


public class UserContext {

    private static UserInfoDTO userInfoDTO;
    private static final ThreadLocal<UserInfoDTO> REQUEST_USER_CONTEXT = ThreadLocal.withInitial(UserInfoDTO::new);


    public static void setUser(UserInfoDTO userInfoDTO){
        REQUEST_USER_CONTEXT.set(userInfoDTO);
    }

    public static UserInfoDTO getUserInfoDto() {
        return (UserInfoDTO)REQUEST_USER_CONTEXT.get();
    }

    public static UserInfoDTO getWholeUser() {
        return userInfoDTO;
    }

}

