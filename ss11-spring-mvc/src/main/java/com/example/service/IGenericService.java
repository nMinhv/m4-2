package com.example.service;

import java.util.List;

public interface IGenericService <T,ID>{

    List<T> getAll();
    boolean save(T t);
    boolean delete(ID id);
    T findByID(ID id);
    boolean update(T t);
}
