package com.learn.jpa_crud_opration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeeDao {

	public void addEmployee(EmployeeEntity employeeEntity) {
		// EntityManager em = Jpautil.getEntityManagerFactory().createEntityManager();
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = createEntityManagerFactory.createEntityManager();
		// EntityTransaction transaction =null;
		try {
			em.getTransaction().begin();
			em.persist(employeeEntity);
			em.getTransaction().commit();
			System.out.println("Employee Saved");
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			Jpautil.shutDown();
		}
	}

	public EmployeeEntity getEmployeeById(Integer id) {
		EntityManager em = Jpautil.getEntityManagerFactory().createEntityManager();
		EmployeeEntity employeeEntity = null;
		try {
			em.getTransaction().begin();
			employeeEntity = em.find(EmployeeEntity.class, id);
			em.getTransaction().commit();
			return employeeEntity;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			Jpautil.shutDown();
		}

		throw new EmployeeNotFoundException("Employee Not Found For This ID" + id);
	}

	public List<EmployeeEntity> getAllEmployee() {
		EntityManager entityManager = Jpautil.getEntityManagerFactory().createEntityManager();
		String query = "SELECT e FROM EmployeeEntity e";
		List<EmployeeEntity> employeeList = null;
		try {
			entityManager.getTransaction().begin();
			Query createQuery = entityManager.createQuery(query);
			employeeList = createQuery.getResultList();
			entityManager.getTransaction().commit();
			return employeeList;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
			Jpautil.shutDown();

		}
		return employeeList;
	}

	public void updateEmployee() {

	}

	public void deleteEmployeebyId(Integer id) {

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = createEntityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		EmployeeEntity deleteById = em.find(EmployeeEntity.class, id);
		em.remove(deleteById);
		em.getTransaction().commit();
		em.close();
		createEntityManagerFactory.close();

	}
}
