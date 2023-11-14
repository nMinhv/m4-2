package com.controller;

import com.dto.StudentDTO;
import com.model.entity.ClassRoom;
import com.model.service.ClassRoomService;
import com.model.service.StudentService;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    public static final SimpleDateFormat dobF = new SimpleDateFormat("yyyy-MM-dd");
    private StudentService studentService = null;
    private ClassRoomService classRoomService = null;

    @Override
    public void init() {
        studentService = new StudentService();
        classRoomService = new ClassRoomService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            getAll(request, response);
            return;
        }
        List<ClassRoom> classList = classRoomService.findAll();
        String getId = request.getParameter("id");
        switch (action) {
            case "add":

                request.setAttribute("classList", classList);
                request.getRequestDispatcher("views/add-student.jsp").forward(request, response);
                break;
            case "update":
                StudentDTO student = studentService.findById(Integer.valueOf(getId));
                request.setAttribute("student", student);
                request.setAttribute("classList", classList);
                request.getRequestDispatcher("views/edit-student.jsp").forward(request, response);
                break;
            case "delete":
                if (getId != null) {
                    deleteStudent(Integer.valueOf(getId));
                }
                break;
            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("act");
        String id = request.getParameter("id");
        switch (a) {
            case "add":
                addStudent(request, response);
                response.sendRedirect("student");
                break;
            case "update":
                if (id != null) {
                    StudentDTO student = studentService.findById(Integer.valueOf(id));
                    boolean isUpdate = studentService.update(student, student.getId());
                    if (isUpdate) {
                        response.sendRedirect("student");
                    }
                }
                break;
        }

    }

    @Override
    public void destroy() {
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentDTO> students = studentService.findAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("views/student.jsp").forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) {
        String fullName = request.getParameter("fullName");
        String bod = request.getParameter("bod");
        int cid = Integer.parseInt(request.getParameter("classId"));
        Date sBod = Date.valueOf(bod);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(fullName);
        studentDTO.setBirthDay(sBod);
        studentDTO.setClassId(cid);
        studentService.create(studentDTO);
    }

    private void deleteStudent(Integer id) {
        studentService.delete(id);
    }
}