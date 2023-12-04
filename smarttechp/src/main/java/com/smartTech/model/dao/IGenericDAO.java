package com.smartTech.model.dao;

import java.util.List;

public interface IGenericDAO <T,ID>{
    List<T> getAll();
    T getOne(ID id);
    boolean updateAndSave(T t);
    boolean delete(ID id);
}
