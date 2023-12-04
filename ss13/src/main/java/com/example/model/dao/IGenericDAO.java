package com.example.model.dao;

import java.util.List;

public interface IGenericDAO <T,ID>{
    List<T> findAll();
    Boolean saveOrUpdate(T t);
    Boolean delete(ID id);
    T findById(ID id);

}
