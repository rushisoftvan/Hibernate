package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Demo {
  
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		
	
		Transaction beginTransaction = openSession.beginTransaction();
		  
		  Employee employee1= new Employee();
		  employee1.setName("rushikesh");
		  
		    Employee employee2= new Employee();
		    employee2.setName("abhishek");
		    
		    Employee employee3 = new Employee();
		    employee3.setName("sachin");
		    
		    
		    Project project1 = new Project();
		    project1.setName("Product Managment System ");
		    
		    
		    Project project2 = new Project();
		    project2.setName("Document ManagmentSystem");
		    
		    List<Project> projects = new ArrayList();
		    projects.add(project1);
		    projects.add(project2);
		    
		      
		     employee1.setProjects(projects);
		    
		     openSession.persist(project1);
		     openSession.persist(project2);
		     openSession.persist(employee1);
		     
	     beginTransaction.commit();
	     sessionFactory.close();
	     HibernateUtil.closeSessionFactory();
	}
	
}
