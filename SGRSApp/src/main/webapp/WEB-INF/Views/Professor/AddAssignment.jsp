<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Assignment</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
</head>
<body>
<div><jsp:include page="/WEB-INF/Views/Header.jsp" /></div>
<div>
	<div id = "menu"><jsp:include page="/WEB-INF/Views/Menu.jsp" /></div>

	<div id="ShowStatus">
		<c:choose>
			<c:when test="${isAssignmentAdded == true}">
				<p style="color: green; font-weight: bold;">Assignment Added to class Successfully </p> 
				<p style="color: green;">Existing Total Percentage Weight of all assignments is ${existingAssignmentWeightage} </p>
			</c:when>
			<c:when test="${isAssignmentAdded == false}">
				<p style="color: red; font-weight: bold;">Adding this Assignment has Issues </p> 
				<p style="color: red;"> Please Enter an Assignment whose Weight is less than ${remainingAssignmentWeightage} </p>
			</c:when>
		</c:choose>
		
	</div>
	<div id="AddAssignment" class="container text-left">
		<div class="row">
			<c:set var="contextPath" value="<%=request.getContextPath() %>" /> 
			<form:form modelAttribute="NewAssignment" action="${contextPath}/ProfessorController/AddAssignment" method="post">
				<div class="col-sm-10 well"> Course Code : <input type="text" name="courseCode" id="courseCode" /></div>
				<div class="col-sm-10 well"> Term : <input type="text" id="term" name="term" /></div>
				<div class="col-sm-10 well"> Assignment Name: <form:input path="assignmentName" /> </div> 
				<div class="col-sm-10 well"> Assignment Description : <form:input  path="assignmentDescription"  /></div> 
				<div class="col-sm-10 well"> Assignment Weight : <form:input  path="percentage" /></div>
				<div class="col-sm-10 well"><input type="submit" name="submit" value="Add Assignment"> </div>
			</form:form> 
		</div>
	</div>
</div>

</body>
</html>