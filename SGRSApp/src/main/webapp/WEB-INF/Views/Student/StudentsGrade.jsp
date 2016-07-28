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

	
	<div id="SelectCourse" class="container text-left">
		<div  class="row">
			<p style="font-weight: bold;">Selected Course: ${SelectedCourse}</p>
		</div>
		<div class="row">
			<p>OverAll Score: ${OverAllMarks}</p>
			<table class="table">
				 <thead>
				    <tr>
				      <th>No.</th>
				      <th>Assignment Name</th>
				      <th>Total Marks</th>
				      <th>Percentage Weight</th>
				      <th>Marks Obtained</th>
				    </tr>
				  </thead>
				  <tbody>
					<c:forEach items="${EnterGrade.assignmentList}" var="assignment" varStatus="status">
				        <tr>
				            <th scope="row">${status.count}</th>
				            <td>${assignment.assignmentName}</td>
				            <td>${assignment.totalMarks}</td>
				            <td>${assignment.percentage}%</td>
				            <td>${assignment.obtainedMarks}</td>
				        </tr>
		   			</c:forEach>
		   		</tbody>
		   		</table>
	
		</div>
	</div>
</div>

</body>
</html>