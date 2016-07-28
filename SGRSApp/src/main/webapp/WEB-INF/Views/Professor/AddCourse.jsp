<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
</head>
<body>
<div><jsp:include page="/WEB-INF/Views/Header.jsp" /></div>
<div>
	<div id = "menu"><jsp:include page="/WEB-INF/Views/Menu.jsp" /></div>

	<div id="ShowStatus">
		<c:if test="${isCourseCreated == true}"> 
				<p style="color: green; font-weight: bold;">Course Created Successfully </p> 
		</c:if>
	</div>
	<div id="AddCourse" class="container text-left">
		<div class="row">
			<c:set var="contextPath" value="<%=request.getContextPath() %>" /> 
			<form:form modelAttribute="NewCourse" action="${contextPath}/ProfessorController/AddCourse" method="post">
				<div class="col-sm-10 well"> Course Name: <form:input path="name" /> </div> 
				<div class="col-sm-10 well"> Course Code : <form:input  path="code"  /></div> 
				<div class="col-sm-10 well">Description : <form:input  path="description" /></div>
				<div class="col-sm-10 well">Term : <form:input path="term"  /></div>
				<div class="col-sm-10 well"><input type="submit" name="submit" value="Add Course"> </div>
			</form:form> 
		</div>
	</div>
</div>

</body>
</html>