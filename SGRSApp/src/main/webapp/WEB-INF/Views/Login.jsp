<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SGRS</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:bundle basename="sgrs"> 
	<fmt:message var="bootstrapVersion" key="bootstrap.version" />
	<link rel='stylesheet' href='<%=request.getContextPath()%>/webjars/bootstrap/<fmt:message key='bootstrap.version'/>/css/bootstrap.min.css'>
</fmt:bundle>
</head>

<body class="container">
	<div class="jumbotron">
		<h1>Student Grading Reporting System</h1>
	</div>
	
	<div style="color: red;">${errorMsg}</div>
	<div class="row">	
		<form name="LoginForm" action="<%=request.getContextPath()%>/AccountController/Login" method="post" >
			User Name: <input type="text" name="userName" id="userName"> <br> 
			Password : <input type="password" name="password"	id="password"> <br> 
			<input type="submit" name="submit" value="Login">
		</form>
	</div>
</body>
</html>