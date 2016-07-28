<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Grades</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
</head>
<body>
<div><jsp:include page="/WEB-INF/Views/Header.jsp" /></div>
<div>
	<div id = "menu"><jsp:include page="/WEB-INF/Views/Menu.jsp" /></div>
	<div> Welcome ${FirstName} ${LastName}, </div>
	<div id="SelectCourse" class="container text-left">
		<div class="row well">
			<c:set var="contextPath" value="<%=request.getContextPath() %>" /> 
			<table class="table">
				 <thead>
				    <tr>
				      <th>Course Code</th>
				      <th>Course Name</th>
				      <th>Term</th>
				      <th>Choose one </th>
				    </tr>
				  </thead>
				  <tbody>
					<c:forEach items="${EnterGrade.courseList}" var="course" varStatus="status">
				        <tr>
				            <td scope="row">${course.code}</td>
				            <td>${course.name}</td>
				            <td>${course.term}</td>
				            <td><a href="<%=request.getContextPath()%>/StudentController/GetAllAssignmentsMarks?courseId=${course.courceId}" />Select This Course</td>
				        </tr>
		   			</c:forEach>
		   		</tbody>
		   		</table>
	
		</div>
	</div>
</div>

</body>
</html>