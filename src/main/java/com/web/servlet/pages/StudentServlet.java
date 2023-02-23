package com.web.servlet.pages;

import com.web.service.StudentService;
import com.web.service.impl.StudentServiceImpl;
import com.web.utils.SingletonUtils;
import com.web.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @author YXS
 * @PackageName: com.web.servlet.pages
 * @ClassName: Student
 * @Desription:
 * @date 2023/2/17 11:08
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        context.setVariable("student_list", SingletonUtils.getStudentServiceSingleton().getStudentList());

        ThymeleafUtil.process("student.html", context, resp.getWriter());

    }

}
