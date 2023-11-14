package com.model.dao;

import com.dto.StudentDTO;
import com.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IGenericDAO<StudentDTO, Integer> {
    @Override
    public List<StudentDTO> findAll() {
        Connection connection = null;
        List<StudentDTO> list = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            String sql = "CALL PROC_GET_ALL_STUDENT()";
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                StudentDTO student = new StudentDTO();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("Student Name"));
                student.setBirthDay(resultSet.getDate("birthDay"));
                student.setClassName(resultSet.getString("class name"));
                list.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return list;
    }

    @Override
    public Boolean create(StudentDTO student) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        System.out.println(student.getClassId());
        String sql = "CALL PROC_INSERT_STUDENT(?,?,?)";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, student.getName());
            cs.setDate(2, student.getBirthDay());
            cs.setInt(3, student.getClassId());
            int check = cs.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Boolean update(StudentDTO student, Integer id) {
        Connection connection = ConnectionDB.openConnection();
        try {
            String sql = "CALL UPDATE_STUDENT_BY_ID(?,?,?,?)";
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1,id);
            cs.setString(2,student.getName());
            cs.setDate(3,student.getBirthDay());
            cs.setInt(4,student.getClassId());
            int c = cs.executeUpdate();
            if(c > 0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "CALL DELETE_STUDENT_BY_ID(?)";
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StudentDTO findById(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        StudentDTO student = new StudentDTO();
        try {
            String sql = "CALL GET_STUDENT_BY_ID(?)";
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                student.setClassId(rs.getInt("Class ID"));
                student.setName(rs.getString("fullName"));
                student.setBirthDay(rs.getDate("birthDay"));
                student.setId(rs.getInt("id"));
                student.setClassName(rs.getString("Class Name"));
                System.out.println(rs.getInt("Class ID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
