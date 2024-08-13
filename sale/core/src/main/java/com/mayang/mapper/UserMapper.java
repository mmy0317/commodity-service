package com.mayang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mayang.dos.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
