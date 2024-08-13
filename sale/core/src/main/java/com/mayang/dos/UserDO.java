package com.mayang.dos;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mayang.common.UserInfoUtil;
import com.mayang.enums.UserStateEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class UserDO {

    /**
     * 用户唯一ID
     */
    @TableId
    @TableField("user_code")
    private String userCode;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户手机号
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 用户状态
     * @see com.mayang.enums.UserStateEnum
     */
    @TableField("state")
    private Integer state;

    /**
     * 用户权限
     * @see com.mayang.enums.RoleEnum
     */
    @TableField("role")
    private String role;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


    public void register(String phoneNumber){
        //step1 自动生成userCode和昵称
        this.setUserCode(UserInfoUtil.getUserCode());
        this.setNickName(UserInfoUtil.getNickName());
        //step2 插入其余数据
        this.setPhoneNumber(phoneNumber);
        this.setState(UserStateEnum.VALID.getCode());
        this.setCreateTime(LocalDateTime.now());
        this.setUpdateTime(LocalDateTime.now());
    }

}
