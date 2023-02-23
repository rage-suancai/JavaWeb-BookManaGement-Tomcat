package com.web.servlet.manage;

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
 * @PackageName: com.web.servlet.manage
 * @ClassName: AddBorrowServlet
 * @Desription:
 * @date 2023/2/20 9:58
 */
@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        context.setVariable("book_list", SingletonUtils.getBookServiceSingleton().getActiveBookList());
        context.setVariable("student_list", SingletonUtils.getBookServiceSingleton().getStudentList());

        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer sid = Integer.parseInt(req.getParameter("student"));
        Integer bid = Integer.parseInt(req.getParameter("book"));
        SingletonUtils.getBookServiceSingleton().addBorrow(sid, bid);
        resp.sendRedirect("add-borrow");

    }

}
