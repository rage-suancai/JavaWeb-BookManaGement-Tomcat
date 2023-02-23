package com.web.servlet.pages;

import com.web.entity.User;
import com.web.service.BookService;
import com.web.service.impl.BookServiceImpl;
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
 * @PackageName: com.web.servlet
 * @ClassName: IndexServet
 * @Desription:
 * @date 2023/2/16 15:58
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("role", user.getRole());
        context.setVariable("borrow_list", SingletonUtils.getBookServiceSingleton().getBorrowList());
        context.setVariable("book_count", SingletonUtils.getBookServiceSingleton().CountBook());
        context.setVariable("borrow_count", SingletonUtils.getBookServiceSingleton().CountBorrow());
        context.setVariable("student_count", SingletonUtils.getStudentServiceSingleton().getStudentList().size());

        ThymeleafUtil.process("index.html", context, resp.getWriter());

    }

}
