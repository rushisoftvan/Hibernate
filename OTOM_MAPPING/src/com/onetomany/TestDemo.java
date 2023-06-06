package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

public class TestDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();

		Question question = new Question();
		question.setContent("what is java");

		Answer answer1 = new Answer();
		answer1.setContent("java is very good language");
		//answer1.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setContent("Java is a programming language");
		//answer2.setQuestion(question);
         
		List<Answer> answers = new ArrayList();
		answers.add(answer2);
		answers.add(answer1);
		question.setAnswers(answers);
		openSession.persist(question);
		//openSession.persist(answer1);
        //openSession.persist(answer2); 	
         Question question2 = openSession.get(Question.class, 1);
		
		System.out.println(question2);
		System.out.println( question2.getAnswers());
        
		beginTransaction.commit();
		openSession.close();
		HibernateUtil.closeSessionFactory();
		
		
	}

}
