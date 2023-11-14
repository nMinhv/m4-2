package com.model.dao;

import com.model.entity.ClassRoom;
import com.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomDAO implements IGenericDAO<ClassRoom, Integer> {

    @Override
    public List<ClassRoom> findAll() {
        Connection connection = null;
        List<ClassRoom> list = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            String sql = "SELECT * FROM class ORDER BY class.id";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                ClassRoom classRoom = new ClassRoom();
                classRoom.setId(resultSet.getInt("id"));
                classRoom.setName(resultSet.getString("name"));
                list.add(classRoom);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return list;
    }

    @Override
    public Boolean create(ClassRoom classRoom) {
        return null;
    }

    @Override
    public Boolean update(ClassRoom classRoom, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ClassRoom findById(Integer integer) {
        return null;
    }
}
