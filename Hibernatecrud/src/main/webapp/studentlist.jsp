<%@page import="com.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.StudentEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<style type="text/css">
   .positionOfButton
   {
      float: right;
    margin-bottom: 10px;
   }
</style>

<script>
 
 function deleteStudent(){
    	 console.log("rushikesh");
    	 var result = confirm("Are You Want To  Delete This?");
    	 if (result) {
    	     return true;
    	 }
    	 return false;
 }

</script>


<body>
	<h1 text class="text-center bg-success">Student List</h1>
	<div>
	       <a class="btn btn-success positionOfButton" href="addstudent.jsp" role="button" >AddStudent</a>
	     </div>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NAME</th>
					<th scope="col">SURNAME</th>
					<th scope="col">AGE</th>
					<th scop="col">EDIT</th>
					<th scop="col">DELETE</th>
					
				</tr>
			</thead>
			<tbody>
				<%
				StudentDao studentDao = new StudentDao();
				List<StudentEntity> students = studentDao.getAllStudent();
				if(students==null){ %>
					<tr>
					<td>data is not available</td>
					</tr>
				<% }
				for (StudentEntity student : students) {
				%>

				<tr>

					<td><%=student.getId()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getSurname()%></td>
					<td><%=student.getAge()%></td>
					<td><a class="btn btn-success" href="updatestudent.jsp?id=<%=student.getId() %>" role="button">Edit</a></td>
					<td><a class="btn btn-success" href="DeleteServlet?id=<%=student.getId() %>" method="get" role="button" onclick=" return deleteStudent();">Delete</a>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>