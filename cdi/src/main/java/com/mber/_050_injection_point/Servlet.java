package com.mber._050_injection_point;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("050")
public class Servlet extends HttpServlet {
    @Inject
    private Logger log;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(log.getName());
        log.log(Level.INFO, log.getName());
    }
}

class MyLogger {
    @Produces
    public Logger getLogger(InjectionPoint ip) {
        return Logger.getLogger(String.format("""
                        Annotated: %s
                        Bean: %s
                        Member: %s
                        Member→DeclaringClass→Name: %s
                        Qualifiers: %s
                        Type: %s
                        isDelegate: %s
                        isTransient: %s
                        """,
                ip.getAnnotated(),
                ip.getBean(),
                ip.getMember(),
                ip.getMember().getDeclaringClass().getName(),
                ip.getQualifiers(),
                ip.getType(),
                ip.isDelegate(),
                ip.isTransient()));
    }
}

