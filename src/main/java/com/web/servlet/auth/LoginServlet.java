package com.web.servlet.auth;

import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;
import com.web.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @author YXS
 * @PackageName: com.web.service
 * @ClassName: RedirectServlet
 * @Desription:
 * @date 2023/2/16 10:05
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static UserService service;

    @Override
    public void init() throws ServletException {

        service = new UserServiceImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();

        resp.setContentType("text/html;charset=UTF-8");

        if (req.getSession().getAttribute("login-failure") != null) {
            context.setVariable("failure", true);
            req.getSession().removeAttribute("login-failure");
        }

        ThymeleafUtil.process("login.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("QR_code");

        HttpSession session = req.getSession();
        String qr_code = (String) session.getAttribute("QR_code");
        if (service.auth(username, password, req.getSession()) && code.equals(qr_code)) {
            resp.sendRedirect("index");
        } else {
            req.getSession().setAttribute("login-failure", new Object());
            this.doGet(req, resp);
        }

    }

}
