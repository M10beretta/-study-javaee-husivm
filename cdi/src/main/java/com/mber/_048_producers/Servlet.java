package com.mber._048_producers;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("048")
public class Servlet extends HttpServlet {
    @Inject @AQ
    private String A;
    @Inject @BQ
    private String B;
    @Inject
    private int i;
    @Inject
    private double d;
    @Inject
    private Car car;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(String.format("""
                A: %s
                B: %s
                i: %s
                d: %s
                car: %s
                """, A, B, i, d, car));
    }
}

class Producer {
    private final String A = "string A";
    private final String B = "string B";
    private final int i = 5;

    @Produces @AQ
    public String getA() {
        return A;
    }

    @Produces @BQ
    public String getB() {
        return B;
    }

    @Produces
    public int getI() {
        return i;
    }

    @Produces
    public double getDouble() {
        return 1 + 3.3 + 5.8;
    }

    @Produces
    public Car getCar() {
        return new Car("Mazda");
    }
}

record Car(String name) {
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, METHOD})
@interface AQ { }

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, METHOD})
@interface BQ { }