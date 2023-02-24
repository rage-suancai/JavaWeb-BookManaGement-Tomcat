package com.web.servlet.pages;

import com.web.entity.User;
import com.web.utils.SingletonUtils;
import com.web.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author YXS
 * @PackageName: com.web.servlet.pages
 * @ClassName: BookServlet
 * @Desription:
 * @date 2023/2/17 11:20
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("book_list", SingletonUtils.getBookServiceSingleton().getBookList().keySet());
        context.setVariable("book_list_status",
                new ArrayList<>(SingletonUtils.getBookServiceSingleton().getBookList().values()));

        ThymeleafUtil.process("book.html", context, resp.getWriter());

    }

}
