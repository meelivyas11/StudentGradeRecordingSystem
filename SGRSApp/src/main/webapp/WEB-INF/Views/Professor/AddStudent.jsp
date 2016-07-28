<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
</head>
<body>
<div><jsp:include page="/WEB-INF/Views/Header.jsp" /></div>
<div>
	<div id = "menu"><jsp:include page="/WEB-INF/Views/Menu.jsp" /></div>

	<div id="ShowStatus">
		<c:if test="${isStudentAdded == true}"> 
				<p style="color: green; font-weight: bold;">Student Added to class Successfully </p> 
		</c:if>
	</div>
	<div id="AddStudent" class="container text-left">
		<div class="row">
			<c:set var="contextPath" value="<%=request.getContextPath() %>" /> 
			<form:form modelAttribute="NewStudent" action="${contextPath}/ProfessorController/AddStudent" method="post">
				<div class="col-sm-10 well"> Student First Name: <form:input path="firstName" /> </div> 
				<div class="col-sm-10 well"> Student Last Name : <form:input  path="lastName"  /></div> 
				<div class="col-sm-10 well"> Student Id : <form:input  path="studentId" /></div>
				<div class="col-sm-10 well"> Course Code : <input type="text" name="courseCode" id="courseCode" /></div>
				<div class="col-sm-10 well"> Term : <input type="text" id="term" name="term" /></div>
				<div class="col-sm-10 well"><input type="submit" name="submit" value="Add Student"> </div>
			</form:form> 
		</div>
	</div>
</div>

</body>
</html>