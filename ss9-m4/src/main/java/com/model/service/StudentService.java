package com.model.service;

import com.dto.StudentDTO;
import com.model.dao.StudentDAO;
import com.model.entity.Student;

import java.util.List;

public class StudentService implements IGenericService<StudentDTO, Integer> {
    private static final StudentDAO studentDAO = new StudentDAO();

    @Override
    public List<StudentDTO> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Boolean create(StudentDTO student) {
        return studentDAO.create(student);
    }

    @Override
    public Boolean update(StudentDTO student, Integer id) {
        return studentDAO.update(student,id);
    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Override
    public StudentDTO findById(Integer id) {
        return studentDAO.findById(id);
    }
}
