package com.learn.jpa_crud_opration;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Jpautil {
	
	private static final String PERSISTENCE_NAME="PERSISTENCE";
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		}
		return entityManagerFactory;
	}
	
	public static void shutDown() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		
	}

}
