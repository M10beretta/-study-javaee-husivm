package com.mber._009_xss_cross_site_scripting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("009")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var one = req.getParameter("one");
        one = Objects.isNull(one) ? "" : one.replaceAll("<", "&lt").replaceAll(">", "&gt;");

        resp.getWriter().write(String.format("""
                <html>
                <head></head>
                <body>
                one = %s
                <form action='009' method='POST'/>
                    <input type='textarea' name='one'>
                    <input type='submit' name='one'/>
                    </form>
                </body>
                </html>
                """, one));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
