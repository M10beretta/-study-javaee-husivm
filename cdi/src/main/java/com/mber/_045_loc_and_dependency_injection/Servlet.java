package com.mber._045_loc_and_dependency_injection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("045")
@NoArgsConstructor
public class Servlet extends HttpServlet {
    @Inject
    private Student studentMike;
    private Student studentElen;
    private Student studentHank;

    @Inject
    public Servlet(Student student) {
        this.studentElen = student;
    }

    @Inject
    public void setStudentHank(Student student) {
        this.studentHank = student;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        studentMike.setName("Mike");
        studentElen.setName("Elen");
        studentHank.setName("Hank");

        resp.getWriter().write(String.format("""
                studentF: %s
                studentC: %s
                studentS: %s
                """, studentMike, studentElen, studentHank));
    }
}

@Getter
@Setter
@ToString
class Student {
    private String name;
}

