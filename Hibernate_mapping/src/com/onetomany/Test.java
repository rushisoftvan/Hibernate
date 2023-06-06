package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Comments;

import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		Session openSession = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Blog blog = new Blog();
		   blog.setContent("java ");
		   
		   Comment comment1 = new Comment();
		   comment1.setContent("this is very good");
		    
		   
		   Comment comment2 = new Comment();
		   comment2.setContent("this is very intersting");
//		   blog.addComments(comment2);
		   
		   List<Comment> listOfComments = new ArrayList();
		   listOfComments.add(comment1);
		   listOfComments.add(comment2);
		  
		  blog.setComments(listOfComments);
		   
		    openSession.persist(blog);
		   Blog blog2 = openSession.get(Blog.class, 1); 
		    System.out.println(blog2);
		   // System.out.println(blog2.getComments());
		  
		Comment comment = openSession.get(Comment.class, 1);
		System.out.println(comment);
		  
		beginTransaction.commit();
		openSession.close();
		HibernateUtil.closeSessionFactory();
	}
}	
