package com.web.dao;

import com.web.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select name,password from users where name = #{name} and password = #{password}") // 查询账号信息
    User getUser(@Param("name") String username, @Param("password") String password);

}
