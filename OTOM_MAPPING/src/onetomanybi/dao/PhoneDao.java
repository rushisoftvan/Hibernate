package onetomanybi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

import onetomanybi.Phone;

public class PhoneDao {
  
	public void savePhone(Phone phone) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction  beginTransaction=null;
		try {
			 beginTransaction = openSession.beginTransaction();
			 openSession.persist(phone);
			 
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
	
}
