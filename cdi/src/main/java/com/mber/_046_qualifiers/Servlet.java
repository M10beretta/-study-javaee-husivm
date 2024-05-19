package com.mber._046_qualifiers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("046")
public class Servlet extends HttpServlet {

    @Inject
    @StudentAnnotation
    private Person personMike;
    @Inject
    private Person personElen;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        personMike.setName("Mike");
        personElen.setName("Elen");
        resp.getWriter().write(String.format("""
                personMike: %s
                personElen: %s
                """, personMike, personElen));
    }
}

interface Person {

    String getName();

    void setName(String name);
}

@StudentAnnotation
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

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE})
@interface StudentAnnotation {
}