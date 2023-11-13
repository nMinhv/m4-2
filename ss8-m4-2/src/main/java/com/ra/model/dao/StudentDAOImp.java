package com.ra.model.dao;

import com.ra.model.entity.Student;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements IGenericDAO<Student, Integer> {

    @Override
    public List<Student> getList() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        try {
            // prepare query
            connection = ConnectionDB.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM demo_jsp.student");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentCode(rs.getInt("studentCode"));
                student.setAge(rs.getInt("age"));
                student.setStudentName(rs.getString("studentName"));
                student.setSex(rs.getBoolean("sex"));
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
    public boolean save(Student student) {
        Connection connection = null;
        try {
            // xay dung truy van
            String sql = "INSERT INTO student( studentName, age, sex) VALUES (?,?,?)";
            connection = ConnectionDB.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, student.getStudentName());
            pst.setInt(2, student.getAge());
            pst.setBoolean(3, student.isSex());
            // thuc thi
            int check = pst.executeUpdate();
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
    public Student findId(Integer i) {
        Connection connection = null;
        Student student = new Student();
        try {
            connection = ConnectionDB.getConnection();
            String sql = "SELECT * FROM STUDENT WHERE studentCode = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, i);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                student.setStudentName(resultSet.getString("studentName"));
                student.setStudentCode(resultSet.getInt("studentCode"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getBoolean("sex"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return student;
    }

    @Override
    public boolean update(Student student, Integer i) {
        Connection connection = null;
        try {
            // xay dung truy van
            String sql = "UPDATE student SET studentName = ?, age = ? , sex = ? WHERE studentCode = ?";
            connection = ConnectionDB.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, student.getStudentName());
            pst.setInt(2, student.getAge());
            pst.setBoolean(3, student.isSex());
            pst.setInt(4, student.getStudentCode());
            // thuc thi
            int check = pst.executeUpdate();
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
    public void delete(Integer i) {
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();
            String sql = "DELETE FROM student WHERE studentCode = ?";
            PreparedStatement pts = connection.prepareStatement(sql);
            pts.setInt(1, i);
            pts.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
