package com.web.dao;

import com.web.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select sid,uid,name,sex,grade from student") // 查询学生信息
    List<Student> getStudentList();

    @Update("update student set name = #{name}, sex = #{sex}, grade = #{grade} where name = #{name}") // 更新学生信息
    int updateStudent(Student student);

}
