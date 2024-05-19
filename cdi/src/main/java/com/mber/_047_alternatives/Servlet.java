package com.mber._047_alternatives;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("047")
public class Servlet extends HttpServlet {

    @Inject
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        person.setName("Mike");
        resp.getWriter().write(String.format("person: %s", person));
    }
}

interface Person {

    String getName();

    void setName(String name);
}

@Alternative
@ToString
class Student implements Person {

    @Getter
    @Setter
    private String name;
}

@ToString
class Worker implements Person {

    @Getter
    @Setter
    private String name;
}
