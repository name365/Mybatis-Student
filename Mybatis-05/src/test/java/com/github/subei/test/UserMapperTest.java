package com.github.subei.test;

import com.github.subei.dao.UserMapper;
import com.github.subei.pojo.User;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 底层主要应用反射

        List<User> users = mapper.getUsers();
        for(User user : users){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
