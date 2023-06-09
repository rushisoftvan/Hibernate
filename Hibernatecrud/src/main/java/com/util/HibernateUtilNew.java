package com.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// this provide
public class HibernateUtilNew {
    
	private static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		try {
			if(factory == null) {
				return	factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
							}
		  
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return factory;
	
	}
	
	public static void closeSeesionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
	
	
}
