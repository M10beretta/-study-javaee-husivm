package com.mber._008_url_parameters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("008post")
public class ServletPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var one = req.getParameter("one");
        var two = req.getParameter("two");

        resp.getWriter().write(String.format("""
                <html>
                <head></head>
                <body>
                one = %s, two = %s
                <form action='008post' method='POST'/>
                    <input type='text' name='one'>
                    <input type='text' name='two'>
                    <input type='submit' name='one'/>
                    </form>
                </body>
                </html>
                """, one, two));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
