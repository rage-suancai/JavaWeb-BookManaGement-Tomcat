package com.web.servlet.manage;

import com.web.service.BookService;
import com.web.service.impl.BookServiceImpl;
import com.web.utils.SingletonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author YXS
 * @PackageName: com.web.servlet.manage
 * @ClassName: ReturnServlet
 * @Desription:
 * @date 2023/2/18 10:27
 */
@WebServlet("/return-book")
public class ReturnServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        SingletonUtils.getBookServiceSingleton().returnBook(id);
        resp.sendRedirect("index");

    }

}
