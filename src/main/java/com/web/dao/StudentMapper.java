package com.web.dao;

import com.web.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select sid,uid,name,sex,grade from student") // 查询学生信息
    List<Student> getStudentList();

    @Update("update student set name = #{name}, sex = #{sex}, grade = #{grade} where sid = #{sid}") // 更新学生信息
    List<Student> updateStudent(@Param("name") String name, @Param("sex") String sex, @Param("grade") String grade);

}
