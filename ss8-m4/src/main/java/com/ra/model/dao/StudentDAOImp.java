package com.ra.model.dao;

import com.ra.model.entity.Student;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements IGenericDAO<Student,Integer> {

    @Override
    public List<Student> getList() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        try {
            // prepare query
            connection = ConnectionDB.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM demo_jsp.student");
            ResultSet rs =  pst.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setStudentCode(rs.getInt("studentCode"));
                student.setAge(rs.getInt("age"));
                student.setStudentName(rs.getString("studentName"));
                student.setSex(rs.getBoolean("sex"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return list;
    }

    @Override
    public boolean save(Student student) {
        return false;
    }

    @Override
    public Student findId(Integer i) {
        return null;
    }

    @Override
    public boolean update(Student student, Integer i) {
        return false;
    }

    @Override
    public void delete(Integer i) {

    }
}
