package com.web.servlet.manage;

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
 * @PackageName: com.web.servlet.manage
 * @ClassName: AddStudentServlet
 * @Desription:
 * @date 2023/2/22 11:25
 */
@WebServlet("/up-student")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ThymeleafUtil.process("update-book.html", new Context(), resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        context.setVariable("update_student",
                SingletonUtils.getStudentServiceSingleton().updateStudent("name", "sex", "grade"));

    }

}
