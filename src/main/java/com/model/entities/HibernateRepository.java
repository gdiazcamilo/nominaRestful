package com.model.entities;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.model.Empleado;

import java.util.List;
import org.hibernate.*;

/**
 * Created by Erick Cortorreal on 24/2/15.
 */
public class HibernateRepository<T> implements IRepository<T> {

    private static SessionFactory ourSessionFactory;
    private static ServiceRegistry serviceRegistry;
    private  Class<T> _class;

    public HibernateRepository(Class<T> _class){
        this._class= _class;
    }

    static {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder stdServiceRegistry =  new StandardServiceRegistryBuilder();
            stdServiceRegistry.applySettings(configuration.getProperties());
            
            serviceRegistry = stdServiceRegistry.build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } 
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
    }

    private static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @Override
    public  T findById(int id){
        T entity = null;
        Session session = getSession();
        try {
           entity = (T)session.get(this._class, id);

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {
            session.flush();
            session.close();
        }

        return  entity;
    }

    @Override
    public  List<T> findAll(){
        List<T> results = null;
        Session session = getSession();
        try {
            results = session.createCriteria(_class).list();

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {
            session.flush();
            session.close();
        }

        return  results;
    }

    @Override
    public List query(String queryStatement) {
        List<T> results = null;
        Session session = getSession();
        try {
            Query query = session.createQuery(queryStatement);
            results = query.list();

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {
            session.flush();
            session.close();
        }
        return  results;
    }

    @Override
    public T create(T entity) {
        Transaction transaction = null;
        Session session = getSession();
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return entity;
    }

    @Override
    public T update(T entity){
        Transaction transaction = null;
        Session session = getSession();
        try {
            transaction = session.beginTransaction();

            session.update(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return entity;
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        Session session = getSession();
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
