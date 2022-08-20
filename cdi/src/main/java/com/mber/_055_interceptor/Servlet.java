package com.mber._055_interceptor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("055")
public class Servlet extends HttpServlet {
    @Inject
    private LiveCycleBean liveCycleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        liveCycleBean.methodA();
        liveCycleBean.methodB();
        liveCycleBean.methodC();
    }
}

class MyInterceptor {
    @AroundConstruct
    private void aroundConstruct(InvocationContext context) throws Exception {
        System.out.println("before construct");
        context.proceed();
    }

    @PostConstruct
    private void postConstruct(InvocationContext context) throws Exception {
        System.out.println("after construct");
        context.proceed();
    }

    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("before method");
        return context.proceed();
    }
}

//@Interceptors(MyInterceptor.class)
class LiveCycleBean {
    public LiveCycleBean() {
        System.out.println("constructor");
    }

    public void methodA() {
        System.out.println("methodA");
    }

    //@ExcludeClassInterceptors
    public void methodB() {
        System.out.println("methodB");
    }

    @Interceptors(MyInterceptor.class)
    public void methodC() {
        System.out.println("methodC");
    }
}
