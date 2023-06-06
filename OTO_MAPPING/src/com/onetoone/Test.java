package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

public class Test {
   
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		  Passport passport = new Passport();
		    passport.setPassportNumber("23456");
		    
		Student student = new Student();
		student.setName("rushikesh");
		student.setPassport(passport);
		
		openSession.persist(student);
		beginTransaction.commit();
		
		Student studentGetById = openSession.get(Student.class,1);
		System.out.println(studentGetById);
		Passport passportOfStudent = studentGetById.getPassport();
		System.out.println(passportOfStudent);
		openSession.close();
		HibernateUtil.closeSessionFactory();
	}
	
}
