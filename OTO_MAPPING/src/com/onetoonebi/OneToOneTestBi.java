package com.onetoonebi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

public class OneToOneTestBi {
    
	
	public static void main(String[] args) {
		 
		
		Transaction beginTransaction = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try (Session openSession = sessionFactory.openSession()) {
			 
			AadharCard aadharCard = new AadharCard();
			aadharCard.setAadharNumber("34567");
		     Worker worker1 = new Worker();
		     worker1.setName("karan");
		     worker1.setAadharCard(aadharCard);
		      beginTransaction = openSession.beginTransaction();
		     //openSession.persist(worker1);
		      AadharCard aadharCard2 = openSession.get(AadharCard.class, 1);
		      openSession.remove(aadharCard2);
		     beginTransaction.commit();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	
}
