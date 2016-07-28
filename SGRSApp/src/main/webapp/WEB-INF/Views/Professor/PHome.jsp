<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor Home</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<div><jsp:include page="/WEB-INF/Views/Header.jsp" /></div>
<div>
	<div id = "menu"><jsp:include page="/WEB-INF/Views/Menu.jsp" /></div>
	<div> Welcome ${FirstName} ${LastName}, </div>
	<div id="MainArea"> 
		<div id="SelectCourse" class="container text-left">
		<div class="row well">
			<div class="row heading">
				<h3 align="center" style="background-color: black; color: white;">Courses</h3>
			</div>
			<div class="row">
				<table class="table">
					 <thead>
					    <tr>
					      <th>Course Id</th>
					      <th>Course Code</th>
					      <th>Course Name</th>
					      <th>Term</th>
					    </tr>
					  </thead>
					  <tbody>
						<c:forEach items="${EnterGrade.courseList}" var="course" varStatus="status">
					        <tr>
					            <th scope="row" align="center">${course.courceId}</th>
					            <td>${course.code}</td>
					            <td>${course.name}</td>
					            <td>${course.term}</td>
					           
					        </tr>
			   			</c:forEach>
			   		</tbody>
			   		</table>
		</div>
	</div>
		
		<div class="row well">
			<div class="row heading">
				<h3 align="center" style="background-color: black; color: white;">Students</h3>
			</div>
			<div class="row">
			<table class="table">
				 <thead>
				    <tr>
				      <th>Student Id</th>
				      <th>First Name</th>
				      <th>Last Name</th>
				    </tr>
				  </thead>
				  <tbody>
					<c:forEach items="${EnterGrade.studentList}" var="studentGrade" varStatus="status">
				        <tr>
				        	<th scope="row" align="center">${studentGrade.studentId}</th>
				            <td>${studentGrade.firstName}</td>
				            <td>${studentGrade.lastName}</td>
				        </tr>
		   			</c:forEach>
		   		</tbody>
		   		</table>
		   	</div>
		</div>
	
	</div>
		
	</div>
</div>

</body>
</html>