package com.web.servlet.manage;

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
 * @ClassName: DeleteServet
 * @Desription:
 * @date 2023/2/21 10:52
 */
@WebServlet("/del-book")
public class DeleteBookServet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer bid = Integer.parseInt(req.getParameter("bid"));
        SingletonUtils.getBookServiceSingleton().deleteBook(bid);
        resp.sendRedirect("book");

    }

}
