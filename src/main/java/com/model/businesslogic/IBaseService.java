package com.model.businesslogic;

import java.util.List;

/**
 * Created by Erick Cortorreal on 2/3/15.
 */
public interface IBaseService<T> {

    T findById(final int id);
    List<T> findAll();
    List<T> query(String query);
    T create(final T entity);
    T update(final T entity);
    void delete(final T entity);
}
