package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.StudentEntity;

import com.util.HibernateUtilNew;

public class StudentDao {
    
	public void  saveStudent(StudentEntity student) {
	  // Session session = HibernateUtil.getSession();
	  // Transaction beginTransaction = session.beginTransaction();
	   //  session.save(student);
	  // beginTransaction.commit();
	  // session.close();
	  // HibernateUtil.closeSessionFactory();
		
		SessionFactory sessionFactory = HibernateUtilNew.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.save(student);
		beginTransaction.commit();
		openSession.close();
		sessionFactory.close();
	}
	
	public List<StudentEntity> getAllStudent() {
		String query ="select s from StudentEntity s";
		SessionFactory sessionFactory = HibernateUtilNew.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Query createQuery = openSession.createQuery(query);
		List<StudentEntity> resultList = createQuery.getResultList();
		beginTransaction.commit();
		openSession.close();
		HibernateUtilNew.closeSeesionFactory();;
		
		return resultList;
	}
	
	
	public StudentEntity getStudentById(Integer id) {
		
		SessionFactory sessionFactory = HibernateUtilNew.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		StudentEntity studentEntity = session.get(StudentEntity.class, id);
		beginTransaction.commit();
		session.close();
		HibernateUtilNew.closeSeesionFactory();
		return studentEntity;
	}
	public void deletStudentById(Integer id) {
		 SessionFactory sessionFactory = HibernateUtilNew.getSessionFactory();
		 Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		StudentEntity studentEntity = session.get(StudentEntity.class, id);
		session.remove(studentEntity);
		beginTransaction.commit();
		session.close();
		HibernateUtilNew.closeSeesionFactory();
	}
	
	public void updateStudent(StudentEntity student) {
		SessionFactory sessionFactory = HibernateUtilNew.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.update(student);
		beginTransaction.commit();
	    openSession.close();
	    HibernateUtilNew.closeSeesionFactory();
	    
		
	}
	
}
