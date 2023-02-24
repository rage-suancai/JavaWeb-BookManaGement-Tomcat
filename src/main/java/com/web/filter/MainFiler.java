package com.web.filter;

import com.web.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author YXS
 * @PackageName: com.web.filter
 * @ClassName: MainFiler
 * @Desription:
 * @date 2023/2/16 11:38
 */
@WebFilter("/*")
public class MainFiler extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String url = req.getRequestURL().toString();

        if(!url.contains("/static/") && !url.contains("code") && !url.endsWith("login")) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

            if(user == null) {
                res.sendRedirect("login"); return;
            }
        }
        chain.doFilter(req, res);

    }

}
