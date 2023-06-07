package onetomanybi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

import onetomanybi.dao.PhoneDao;
import onetomanybi.dao.StudentDao;

public class TestBi {
  
/*	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction=null;
		try {
			 beginTransaction = openSession.beginTransaction();
			 Student student = new Student();
			 student.setName("Rushikesh");
			 
			 Phone phone1 = new Phone();
			 phone1.setName("vivo");
			 
			 Phone phone2 = new Phone();
			 phone2.setName("appo");
			 
			 student.addPhone(phone2);
			 student.addPhone(phone1);
			 
			 openSession.persist(student);
			 openSession.persist(phone2);
			 openSession.persist(phone1);
			 
			 beginTransaction.commit();
		}
		catch(Exception e){
			if(beginTransaction!=null) {
				beginTransaction.rollback();
			}
		}
		finally {
			openSession.close();
			sessionFactory.close();
		}
	}
	*/
	
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		PhoneDao phoneDao = new PhoneDao();
		
		Student student = new Student();
		student.setName("abhishek");
		
		
		
		//Student studentById = studentDao.getStudentById(3);
		
		//Phone phone1 = new Phone();
		//phone1.setName("appo");
		//student.addPhone(phone1);
		//studentDao.saveStuddent(student);
		
		//phoneDao.savePhone(phone1);
		
		Student studentById = studentDao.getStudentById(5);
		System.out.println(studentById);
		
		//List<Student> allStudent = studentDao.getAllStudent();
		//System.out.println(allStudent);
		

		
	}
}
