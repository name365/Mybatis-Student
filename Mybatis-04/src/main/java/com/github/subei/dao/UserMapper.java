package com.github.subei.dao;

import com.github.subei.pojo.User;

public interface UserMapper {

    // 根据ID查询用户
    User getUserById(int id);

}