package com.controller;

import com.model.entity.ClassRoom;
import com.model.service.ClassRoomService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ClassRoomServlet", value = "/class")
public class ClassRoomServlet extends HttpServlet {
    private static final ClassRoomService classroomService = new ClassRoomService();
    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClassRoom> classRooms = classroomService.findAll();
        request.setAttribute("list",classRooms);

        request.getRequestDispatcher("views/classroom.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
    }

}