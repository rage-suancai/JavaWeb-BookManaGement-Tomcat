package com.web.service;

import com.web.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    boolean UpdateStudent(Student student);

}
