package com.mber._007_servlets_and_multithreading;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@WebServlet("007")
public class Servlet extends HttpServlet implements SingleThreadModel {

    private int i;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var begin = System.currentTimeMillis();

        for (int j = 0; j < 100_000_000; j++) {
            i++;
        }
        System.out.printf("%s %s %d%n", Thread.currentThread().getName(), i, System.currentTimeMillis() - begin);
    }

    public static class MultithreadingConnectionTest {

        public static void main(String[] args) {

            var executorService = Executors.newFixedThreadPool(5);
            IntStream.range(0, 5).forEach(i -> executorService.submit(MultithreadingConnectionTest::connect));
            executorService.shutdown();
        }

        @SneakyThrows
        static void connect() {
            new URL("http://localhost:8080/servlets-1.0-SNAPSHOT/007").openConnection().getInputStream();
        }
    }
}