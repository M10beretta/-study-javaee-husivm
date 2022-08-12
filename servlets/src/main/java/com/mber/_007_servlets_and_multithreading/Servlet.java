package com.mber._007_servlets_and_multithreading;

import lombok.Getter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("007")
public class Servlet extends HttpServlet {

    @Getter
    private static final AtomicInteger i = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int j = 0; j < 100_000_000; j++) {
                i.incrementAndGet();
        }
        System.out.printf("%s %s%n", Thread.currentThread().getName(), i);
    }
}
