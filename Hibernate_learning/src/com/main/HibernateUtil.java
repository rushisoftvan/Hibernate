package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
	private static SessionFactory factory = null;
	static {
		try {
			factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		Session session=null;
		// it will check if thread not have seeion object to create 
		if(threadLocal.get()==null) {
			session = factory.openSession();
			threadLocal.set(session);
		}
		else {
			session =  threadLocal.get();
		}
		return session;
		
	}
	
	public static void closeSession() {
		Session session = null;
		if(threadLocal.get()!=null) {
			threadLocal.get().close();
			threadLocal.remove();
			
		}
	}
	
	public static void closeSessionFactory() {
		factory.close();
	}

}
