package com.mber._052_conversation_scope;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("052")
public class Servlet extends HttpServlet {
    @Inject
    private ConversationBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        printOutsideAndInsideStates();
        initBean("A");
        printOutsideAndInsideStates();

        bean.startConversation();

        printOutsideAndInsideStates();
        initBean("C");
        printOutsideAndInsideStates();
        initBean("D");
        printOutsideAndInsideStates();

        bean.endConversation();

        printOutsideAndInsideStates();
        initBean("E");
        printOutsideAndInsideStates();
    }


    private void initBean(String s) {
        bean.stF = s;
        bean.setStS(s);
        System.out.println("outside, set states - " + s);
    }

    private void printOutsideAndInsideStates() {
        printOutsideStates();
        bean.printInsideStates();
    }

    private void printOutsideStates() {
        System.out.printf("outside, stF: %s%n", bean.stF);
        System.out.printf("outside, stS: %s%n", bean.getStS());
    }
}

