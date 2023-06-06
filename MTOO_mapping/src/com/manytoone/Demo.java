package com.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

public class Demo {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Blog blog = new Blog();
		blog.setContent("java");
		
		Comment comment1 = new Comment();
		comment1.setContent("this is veru good");
		comment1.setBlog(blog);
		
		openSession.persist(comment1);
		
		Comment commentById = openSession.get(Comment.class, 1);
		System.out.println(commentById);
		
		beginTransaction.commit();
		openSession.close();
		HibernateUtil.closeSessionFactory();
	}
}
