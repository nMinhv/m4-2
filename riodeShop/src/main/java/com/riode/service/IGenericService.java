package com.riode.service;

import java.util.List;

public interface IGenericService <T,ID>{
    List<T> getAll();
    T getOne(ID id);
    boolean updateAndSave(T t);
    boolean delete(ID id);
}
