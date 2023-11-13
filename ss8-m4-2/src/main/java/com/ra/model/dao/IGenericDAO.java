package com.ra.model.dao;

import java.util.List;

public interface IGenericDAO<T,ID> {
    List<T> getList();

    boolean save(T t);
    T findId(ID id);
    boolean update(T t, ID id);
    void delete(ID id);

}
