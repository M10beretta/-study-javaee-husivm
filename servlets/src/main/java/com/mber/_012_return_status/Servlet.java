package com.mber._012_return_status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("012")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(HttpServletResponse.SC_OK);
//        resp.sendRedirect("/");
//        resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"error");
        resp.setHeader("Refresh", "5;URL=https://www.google.com");
    }
}
