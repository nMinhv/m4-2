package com.example.model.dao;

import java.util.List;

public interface IGenericDAO <T,ID>{
    Boolean updateAndSave(T t);
    T findById(ID id);
    Boolean delete (ID id);
    List<T> getAll();

}
