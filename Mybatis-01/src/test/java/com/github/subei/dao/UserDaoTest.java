package com.github.subei.dao;

import com.github.subei.pojo.User;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        //方式二：不推荐使用！！！
//        List<User> userList = sqlSession.selectList("com.github.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void addUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4,"好多鱼","421563"));
        if(res>0){
            System.out.println("插入成功！！");
        }

        //提交事务
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(4,"好多鱼","233333"));
        if(res>0){
            System.out.println("上传成功！！");
        }

        //提交事务
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(4);
        if(res>0){
            System.out.println("删除成功！！");
        }

        //提交事务
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }

}