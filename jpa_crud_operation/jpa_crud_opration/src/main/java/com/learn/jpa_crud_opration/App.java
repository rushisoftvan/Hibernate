package com.learn.jpa_crud_opration;

import java.util.List;

import jakarta.persistence.EntityManagerFactory;

/**
 * Hello world!
 *
 */
public class App 
{    
	
    public static void main( String[] args )
    {
    	EmployeeDao employeeDao = new EmployeeDao();
    	
    	
       // save Employee
    	
    	/*
    	   EmployeeEntity employeeEntity1 = new EmployeeEntity("rushikesh", "malvadkar", 21);
    	   EmployeeEntity employeeEntity2 = new EmployeeEntity("abhishek", "malvadkar", 21);
    	   EmployeeEntity employeeEntity3 = new EmployeeEntity("sachin", "yadhav", 21);
    	   employeeDao.addEmployee(employeeEntity1);
    	   employeeDao.addEmployee(employeeEntity2);
    	   employeeDao.addEmployee(employeeEntity3);
    	   **/
    	
    	     //getBY ID
    	   
    	//EmployeeEntity employee = employeeDao.getEmployeeById(1);
    	//System.out.println(employee);
    	//Integer age = employee.getAge();
    	 //System.out.println(age);//  
           
    	// GET ALL Employee
    	  //List<EmployeeEntity> allEmployee = employeeDao.getAllEmployee();
    	  //System.out.println(allEmployee);
         
    	  //Delete Employee
    	  employeeDao.deleteEmployeebyId(3);
    	
    	
    }
}
