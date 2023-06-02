package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.entity.StudentEntity;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private StudentDao studentDao= new StudentDao();  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name = request.getParameter("name");
		String surname= request.getParameter("surname");
		Integer age =Integer.parseInt(request.getParameter("age")); 
		System.out.println(name);
		System.out.println(age);
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setName(name);
		studentEntity.setAge(age);
		studentEntity.setSurname(surname);
		
		if(studentEntity!=null) {
			studentDao.saveStudent(studentEntity);
		}
		PrintWriter writer = response.getWriter();
		//request.getSession().setAttribute("message", "data is added");
		response.sendRedirect("studentlist.jsp");
		
		
	}

}
