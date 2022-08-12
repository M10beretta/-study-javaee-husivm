package com.mber._014_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("014")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String s = attributeNames.nextElement();
            System.out.printf("%s = %s%n", s, session.getAttribute(s));
        }
        session.setAttribute("one", "two");
//        session.removeAttribute("one");
        System.out.printf("MaxInactiveInterval: %s", session.getMaxInactiveInterval());
        System.out.printf("isNew: %s", session.isNew());
//        session.invalidate();
    }
}
