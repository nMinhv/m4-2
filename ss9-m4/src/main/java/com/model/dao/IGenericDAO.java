package com.model.dao;

import java.util.List;

public interface IGenericDAO <T,ID>{
    List<T> findAll();
    Boolean create(T t);
    Boolean update(T t, ID id);
    void delete(ID id);
    T findById(ID id);

}
