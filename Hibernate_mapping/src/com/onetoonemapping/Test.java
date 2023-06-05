package com.onetoonemapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onetomany.Blog;
import com.onetomany.Comment;
import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		Session openSession = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Blog blog = new Blog();
		   blog.setContent("java ");
		   Comment comment1 = new Comment();
		   comment1.setContent("this is very good");
		   comment1.setBlog(blog);
		   Comment comment2 = new Comment();
		   comment2.setContent("this is very intersting");
		   comment2.setBlog(blog);
		   		   
		    openSession.save(blog);
		    openSession.save(comment1);
		    openSession.save(comment2);
		    
		   Blog blog2 = openSession.get(Blog.class, 1);
		   List<Comment> comments = blog2.getComments();
		   System.out.println(comments);
		  System.out.println(blog2);
		   
		  
		  
		beginTransaction.commit();
		openSession.close();
		HibernateUtil.closeSessionFactory();
	}
}
