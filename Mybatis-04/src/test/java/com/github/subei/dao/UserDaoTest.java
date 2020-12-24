package com.github.subei.dao;

import com.github.subei.pojo.User;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

//      RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

//      通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.github.subei.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);

        List<User> userList =  mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }


    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.info("info:进入了testLog4j");

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user = userDao.getUserById(1);

        System.out.println(user.toString());

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
}