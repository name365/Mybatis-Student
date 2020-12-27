package com.github.subei.dao;

import com.github.subei.pojo.Student;

import java.util.List;

public interface StudentMapper {
    // 查询所有的学生的信息，以及对应老师的信息
    public List<Student> getStudent();

    // 查询所有的学生的信息，以及对应老师的信息
    public List<Student> getStudent2();
}
