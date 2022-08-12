package com.mber._008_url_parameters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("008")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("Parameters(one, two, three): %s %s %s%n", req.getParameter("one"), req.getParameter("two"), req.getParameter("three"));

        System.out.printf("ParameterValues(four): %s%n", Arrays.toString(req.getParameterValues("four")));

        StringBuilder builder = new StringBuilder("ParameterNames: ");
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            builder.append(" ").append(names.nextElement());
        }
        System.out.println(builder);

        System.out.printf("RequestURL: %s%n", req.getRequestURL());
        System.out.printf("RequestURI: %s%n", req.getRequestURI());
        System.out.printf("ServletPath: %s%n", req.getServletPath());
        System.out.printf("RemoteHost: %s%n", req.getRemoteHost());
        System.out.printf("LocalPort: %s%n", req.getLocalPort());
        System.out.printf("QueryString: %s%n", req.getQueryString());
    }
}

