package com.model.service;

import com.model.dao.ClassRoomDAO;
import com.model.entity.ClassRoom;

import java.util.List;

public class ClassRoomService implements IGenericService<ClassRoom,Integer>{
    private static final ClassRoomDAO classRoomDao = new ClassRoomDAO();
    @Override
    public List<ClassRoom> findAll() {
        return classRoomDao.findAll();
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
        classRoomDao.delete(id);
    }

    @Override
    public ClassRoom findById(Integer integer) {
        return null;
    }
}
