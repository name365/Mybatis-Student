package com.github.subei.dao;

import com.github.subei.pojo.User;

import java.util.List;

public interface UserMapper {

    // 根据ID查询用户
    User getUserById(int id);

}