package com.github.subei.dao;

import com.github.subei.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
}