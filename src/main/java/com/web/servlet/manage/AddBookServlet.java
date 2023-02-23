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

import javax.sound.midi.Soundbank;
import java.io.IOException;

/**
 * @author YXS
 * @PackageName: com.web.servlet.manage
 * @ClassName: AddBookServlet
 * @Desription:
 * @date 2023/2/21 15:46
 */
@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ThymeleafUtil.process("add-book.html", new Context(), resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Double price = Double.parseDouble(req.getParameter("price"));
        SingletonUtils.getBookServiceSingleton().addBook(title, content, price);
        resp.sendRedirect("add-book");

    }

}
