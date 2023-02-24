package com.web.service.impl;

import com.web.dao.StudentMapper;
import com.web.entity.Student;
import com.web.service.StudentService;
import com.web.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author YXS
 * @PackageName: com.web.service.impl
 * @ClassName: StudentServiceImpl
 * @Desription:
 * @date 2023/2/22 9:28
 */
public class StudentServiceImpl implements StudentService {

    SqlSession sqlSession = MybatisUtil.getSession(true);
    StudentMapper mapper;

    @Override
    public List<Student> getStudentList() {

        mapper = sqlSession.getMapper(StudentMapper.class);
        return mapper.getStudentList();

    }

    @Override
    public List<Student> updateStudent(String name, String sex, String grade) {

        return mapper.updateStudent(name, sex, grade);

    }

}
