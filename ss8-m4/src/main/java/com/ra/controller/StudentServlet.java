package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;
import jakarta.servlet.http.HttpServlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private  StudentService studentService;
    @Override
    public void init() {
         studentService = new StudentService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        request.setAttribute("list",studentList);
        request.getRequestDispatcher("views/student.jsp").forward(request,response);
        System.out.println(1);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
    }
}