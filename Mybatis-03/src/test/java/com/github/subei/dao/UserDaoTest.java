package com.github.subei.dao;

import com.github.subei.pojo.User;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user = userDao.getUserById(1);

        System.out.println(user.toString());

        //关闭SqlSession
        sqlSession.close();
    }

//    select * from mybatis.user where id = #{id}
//类型处理器
//    select id,name,pwd as password from mybatis.user where id = #{id}

}