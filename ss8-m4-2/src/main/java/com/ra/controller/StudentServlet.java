package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() {
        studentService = new StudentService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        String a = request.getParameter("action");
        if (a == null) {
            getAll(request, response);
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        switch (a) {
            case "delete":
                studentService.delete(id);
                getAll(request, response);
                break;
            case "edit":
                Student student = studentService.findId(id);
                request.setAttribute("student", student);
                request.getRequestDispatcher("views/student-edit.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("action");
        req.setCharacterEncoding("UTF-8");
        String studentName = req.getParameter("studentName");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean sex = Boolean.parseBoolean(req.getParameter("sex"));
        switch (a) {
            case "save":
                studentService.save(new Student(studentName, age, sex));
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Student student = studentService.findId(id);
                studentService.update(student,id);
                break;
        }
        resp.sendRedirect("/students");
    }

    @Override
    public void destroy() {
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        request.setAttribute("list", studentList);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);

    }
}