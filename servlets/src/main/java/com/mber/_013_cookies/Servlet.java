package com.mber._013_cookies;

import lombok.NonNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@WebServlet("013")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(@NonNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();
        if (Objects.nonNull(cookies)) {
            Arrays.stream(cookies).forEach(x -> System.out.printf("""
                    MaxAge:%s Name:%s Value:%s
                    """, x.getName(), x.getValue(), x.getMaxAge()));
        }
        var cookie = new Cookie("testCooke", "abc");

        resp.addCookie(cookie);
        cookie.setMaxAge(5);
        cookie.setDomain("second.my.localhost");
        cookie.setPath("/");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
    }
}
