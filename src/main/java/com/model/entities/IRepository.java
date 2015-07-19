package com.model.entities;

import java.util.List;

public interface IRepository<T> {

    T findById(final int id);

    List<T> findAll();

    List<T> query(String queryStatement);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

}