<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:bundle basename="sgrs">
	<fmt:message var="bootstrapVersion" key="bootstrap.version" />
	<link rel='stylesheet'
		href='../webjars/bootstrap/<fmt:message key='bootstrap.version'/>/css/bootstrap.min.css'>
</fmt:bundle>

<%
	session = request.getSession();
	String role = (String) session.getAttribute("UserRole");
	String userName = (String) session.getAttribute("UserName");
	String FirstName = (String) session.getAttribute("FirstName");
	String LastName = (String) session.getAttribute("LastName");
%>

</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
	
		<%
			if (role != null && role.equals("Professor")) {
		%>
		<div class="collapse navbar-collapse" id="ProfessorMenu">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/ProfessorController/Home">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/ProfessorController/AddCourseView">Add Course</a></li>
				<li><a href="<%=request.getContextPath()%>/ProfessorController/AddStudentView">Add Students</a></li>
				<li><a href="<%=request.getContextPath()%>/ProfessorController/AddAssignmentView">Add Assignments</a></li>
				<li><a href="<%=request.getContextPath()%>/ProfessorController/EnterGradesView">Enter Grades</a></li>
				<li class="navbar-right"><a href="<%=request.getContextPath()%>/AccountController/LoginView">Logout</a></li>
			</ul>
		</div>
		
		<%
			} else if (role != null && role.equals("Student")) {
		%>
		<div class="collapse navbar-collapse" id="StudentMenu">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/StudentController/SeeStudentCourses">Home</a></li>
				<li class="navbar-right"><a href="<%=request.getContextPath()%>/AccountController/LoginView">Logout</a></li>
			</ul>

		</div>
		<%
			}
		%>
	</div>
	</nav>
</body>
</html>