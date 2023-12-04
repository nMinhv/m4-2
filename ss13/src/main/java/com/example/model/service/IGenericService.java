package com.example.model.service;

import java.util.List;

public interface IGenericService <T,ID>{
    List<T> findAll();
    Boolean saveOrUpdate(T t);
    Boolean delete(ID id);
    T findById(ID id);
}
