package com.gu.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gu.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    
    @Select("select * from cloud_user.tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}