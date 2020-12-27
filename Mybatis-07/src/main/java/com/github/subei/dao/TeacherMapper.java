package com.github.subei.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.subei.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    // 获取老师
   // List<Teacher> getTeacher();

    // 获取指定老师下的所有的学生及老师信息
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);
}
