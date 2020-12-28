package com.github.subei.dao;

import com.github.subei.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 根据ID查询用户
    User queryUserById(@Param("id")int id);

    // 修改用户
    int updateUser(User user);
}
