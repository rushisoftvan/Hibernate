package com.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

public class Main {
      
	public static void main(String[] args) {
		Session openSession = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Passport passport = new Passport();
		passport.setNumber("34567");
		
		Student student = new Student();
		student.setName("rushikesh");
		student.setPassport(passport);
		openSession.save(student);
		Student student1 = openSession.get(Student.class, 1);
		System.out.println(student1.getPassport());
		System.out.println(student1);
		Passport passport2 = openSession.get(Passport.class, 1);
		Student student2 = passport2.getStudent();
		System.out.println(student2);
	     System.out.println(passport2);
		beginTransaction.commit();
		openSession.close();
		HibernateUtil.closeSessionFactory();
	}
	
	
	
}
