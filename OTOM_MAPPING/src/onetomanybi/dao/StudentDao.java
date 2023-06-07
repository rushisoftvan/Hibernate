package onetomanybi.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

import onetomanybi.Student;

public class StudentDao {
	
	
	public void saveStuddent(Student student) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction  beginTransaction=null;
		try {
			 beginTransaction = openSession.beginTransaction();
			 openSession.persist(student);
			 
			beginTransaction.commit();
		}
		catch(Exception e)
		{
			beginTransaction.rollback();
			
		}
		finally {
			openSession.close();
			HibernateUtil.closeSessionFactory();
		}
	}
	
	
	public Student getStudentById(Integer id) {
		 
		//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//Session openSession = sessionFactory.openSession();
		////Transaction  beginTransaction=null;
		///try {
			// beginTransaction = openSession.beginTransaction();
			 
			//  student = openSession.get(Student.class, id);
			 //student.getPhones();
			 
			//beginTransaction.commit();
	        		
		//}
		//catch(Exception e)
		//{
		///	e.printStackTrace();
			//beginTransaction.rollback();
			
		//}
		//finally {
			//openSession.close();
			
		//}
		
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
          Transaction beginTransaction=null;
        Student student=null;
        SessionFactory buildSessionFactory = configuration.buildSessionFactory();
        try (Session openSession = buildSessionFactory.openSession()) {
        	 beginTransaction = openSession.beginTransaction();
        	  student = openSession.get(Student.class, id);
        	  student.getPhones();
        	 beginTransaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return student;
        
        
	    
	}
	
	
	public List<Student> getAllStudent() {
        String query = "SELECT  s FROM Student s";
        List<Student> students=null;
    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory buildSessionFactory = configuration.buildSessionFactory();
        try (Session openSession = buildSessionFactory.openSession()) {
			Transaction beginTransaction = openSession.beginTransaction();
			  
			Query createQuery = openSession.createQuery(query);
			 students = createQuery.getResultList();
			    
			beginTransaction.commit();
			
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return students;
	}

}
