package com.github.subei.test;

import com.github.subei.dao.UserMapper;
import com.github.subei.pojo.User;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(5);

        sqlSession.close();
    }
}

/*
        List<User> users = mapper.getUsers();
        for(User user : users){
            System.out.println(user);
        }

        User userByID = mapper.getUserByID(1);
        System.out.println(userByID);

        mapper.addUser(new User(5,"hello","123456"));

        mapper.updateUser(new User(5,"to","213213"));

        mapper.deleteUser(5);

 */
