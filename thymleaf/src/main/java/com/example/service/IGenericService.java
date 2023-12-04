package com.example.service;

import java.util.List;

public interface IGenericService<T, ID> {
    Boolean updateAndSave(T t);

    T findById(ID id);

    Boolean delete(ID id);

    List<T> getAll();
}
