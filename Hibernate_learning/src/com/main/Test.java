package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
  public static void main(String[] args) {
	  // it will start the hibernate framwork 
	  
	 // Configuration configuration = new Configuration();
	  
	  // it will read the configration file and validate
	  //configuration.configure("hibernate.cfg.xml");
	  
	  //It will create connection pool and give the session object to do the persistence operation
	 // SessionFactory buildSessionFactory = configuration.buildSessionFactory();
	  //Session openSession = buildSessionFactory.openSession();
	  
	  //Student student1 = new Student("rushikesh");
	  //openSession.beginTransaction();
	 // openSession.save(student1);
	  //Student student = openSession.get(Student.class, 2);
	 // String name = student.getName();
	//.out.println(name);
	  //System.out.println(buildSessionFactory);
	 // openSession.close();
	 // buildSessionFactory.close();
	  
	  
	 
	  
	  
      //Test.saveStudent(student);
	  
	  
      //Student studentById = Test.getStudentById(3);
	  
	/**  
	  
	  Student student = new Student();
	  student.setId(3);
	  student.setName("rushikesh");
	  Test.deleteStudent(student);
      System.out.println(studentById.getName());
      **/
	  
}
  
  public static  void  saveStudent(Student student) {
	  Session session = HibernateUtil.getSession();
	  Transaction beginTransaction = session.beginTransaction();
	  session.save(student);
	  beginTransaction.commit();
	  HibernateUtil.closeSession();
	  HibernateUtil.closeSessionFactory();
	  
  }
  
  public static Student getStudentById(Integer id) {
	 Session session = HibernateUtil.getSession();
	 Transaction beginTransaction = session.beginTransaction();
	 Student student = session.get(Student.class,id );
	 beginTransaction.commit();
	 HibernateUtil.closeSession();
	 HibernateUtil.closeSessionFactory();
	 return student;
	 
  }
  
  public static void deleteStudent(Student student) {
	 
	  Session session = HibernateUtil.getSession();
	  Transaction beginTransaction = session.beginTransaction();
	  session.delete(student);
	  beginTransaction.commit();
	  HibernateUtil.closeSession();
	  HibernateUtil.closeSessionFactory();
  }
}
