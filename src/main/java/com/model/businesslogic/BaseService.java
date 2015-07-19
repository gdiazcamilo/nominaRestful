package com.model.businesslogic;


import java.util.List;

import com.model.entities.HibernateRepository;
import com.model.entities.IRepository;

/**
 * Created by Erick Cortorreal on 26/2/15.
 */
 class BaseService<T> implements IBaseService<T> {

    private Class<T> _class;

    protected IRepository<T> repository;
    public BaseService(Class<T> _class){
        this._class = _class;
        this.repository = new HibernateRepository<T>(_class);

    }

    public T findById(final int id){
        return this.repository.findById(id);
    }

    public List<T> findAll(){
        return this.repository.findAll();
    }

    public List<T> query(String query){
        return this.query(query);
    }

    public T create(final T entity) {
    	return this.repository.create(entity);
	}

    public T update(final T entity){
        return this.repository.update(entity);
    }

    public void delete(final T entity){
        this.repository.delete(entity);
    }


}
