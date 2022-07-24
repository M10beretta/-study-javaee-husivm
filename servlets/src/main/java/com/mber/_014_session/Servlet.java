package com.mber._014_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("014")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            var s = attributeNames.nextElement();
            System.out.printf("%s = %s%n", s, session.getAttribute(s));
        }
        session.setAttribute("one", "two");
//        session.removeAttribute("one");
        System.out.printf("MaxInactiveInterval: %s", session.getMaxInactiveInterval());
        System.out.printf("isNew: %s", session.isNew());
//        session.invalidate();
    }
}
