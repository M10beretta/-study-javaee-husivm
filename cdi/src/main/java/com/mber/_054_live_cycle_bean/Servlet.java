package com.mber._054_live_cycle_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("054")
public class Servlet extends HttpServlet {
    @Inject
    private LiveCycleBean liveCycleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        liveCycleBean.methodA();
        liveCycleBean.methodB();
    }
}

class LiveCycleBean {
    public LiveCycleBean() {
        System.out.println("1 constructor");
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("2 after construct");
    }

    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("3,5 before method");
        return context.proceed();
    }

    public void methodA() {
        System.out.println("4 methodA");
    }

    public void methodB() {
        System.out.println("6 methodB");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("7 before destroy");
    }
}
