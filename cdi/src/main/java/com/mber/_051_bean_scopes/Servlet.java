package com.mber._051_bean_scopes;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("051")
public class Servlet extends HttpServlet {
    @Inject
    private MyBean bean;
    @Inject
    private ChangeMyBean change;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bean.setI(5);
        change.changeI();
        resp.getWriter().write("i: " + bean.getI());

    }
}

//@ApplicationScoped
//@SessionScoped
//@RequestScoped
//@ConversationScoped
@Dependent
class MyBean {
    @Getter
    @Setter
    private int i;
}

class ChangeMyBean {
    @Inject
    private MyBean myBean;

    public void changeI() {
        myBean.setI(2);
    }
}

