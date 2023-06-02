<%@page import="com.dao.StudentDao"%>
<%@page import="com.entity.StudentEntity" %>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>

<script>

  function validation(){
	  //$("#nameValidation").hide();
	  var letters =/^[A-Za-z]+$/;
	  
	  
	  
	  
	  
	  console.log("rushikesh");
	  var name= $("#n").val().trim();
	  var surname=$("#surname").val().trim();
	  var age=$("#age").val().trim();
	  var newAge=parseInt(age);
	  console.log(name);
	  
	  if(name=="" || !letters.test(name)){
		  $("#nameValidation").show();
		  $("#surnameValidation").hide();
		  $("#ageValidation").hide();
		  return false;
	  }
	  else if(surname="" || !letters.test(surname))
	  {
		  $("#surnameValidation").show();
		  $("#nameValidation").hide();
		  $("#ageValidation").hide();
		  return false;
	  }
	  else if(age="" || isNaN(newAge)){
		  $("#ageValidation").show();
		  $("#surnameValidation").hide();
		  $("#nameValidation").hide();
		  return false;
	  }
        return true;	  
  }
</script>




<body class="container">
	<h1 class="text-center bg-info">Student Edit Form</h1>
	<%
	 int id=Integer.parseInt(request.getParameter("id").trim());
	      StudentDao studentdao=new StudentDao();
	      StudentEntity student=studentdao.getStudentById(id);
	%>
	<form action="UpdateServlet" method="post" onsubmit="return validation();">
	    <input  value="<%=student.getId()%>" type="hidden" name="id"> 
		<div class="form-group">
			<label for="exampleInputEmail1">Student Name</label> <input
				type="text" class="form-control" id="n" name="name"
				placeholder="Enter name" value="<%=student.getName()%>">
		</div>
		<div class="alert alert-danger" role="alert" id="nameValidation" style="display:none;">
		  Please Enter vaild name
		</div>
		
		<div class="form-group">
			<label>Student Surname</label> <input type="text"
				class="form-control" id="surname" name="surname"
				placeholder="Enter Student surname" value="<%=student.getSurname()%>">
		</div>
		
		<div class="alert alert-danger" role="alert" id="surnameValidation" style="display:none;">
		  Please Enter vaild surname
		</div>
		
		<div class="form-group">
			<label for="exampleInputPassword1">Student Age</label> <input
				type="text" class="form-control" id="age" name="age"
				placeholder="age" value="<%=student.getAge()%>">
		</div>
		
			<div class="alert alert-danger" role="alert" id="ageValidation" style="display:none;">
		  Please Enter valid age</div>

		<button type="submit" class="btn btn-primary">Update</button>
	</form>
</body>
</html>