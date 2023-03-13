package com.design.weidesignservice.mapper;

import com.design.weidesignservice.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);
    void insert(@Param("Id") String Id, @Param("username") String username, @Param("password") String password, @Param("showName") String showName);
}
