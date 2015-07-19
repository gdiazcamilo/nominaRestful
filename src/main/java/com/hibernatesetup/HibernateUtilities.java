package com.hibernatesetup;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
		try{
			Configuration config = new Configuration().configure();
			
			StandardServiceRegistryBuilder stdServiceRegistry =  new StandardServiceRegistryBuilder();
			stdServiceRegistry.applySettings(config.getProperties());
			
			serviceRegistry = stdServiceRegistry.build();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}
		catch(HibernateException hex ){
			System.out.println("Problem creating session factory");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
