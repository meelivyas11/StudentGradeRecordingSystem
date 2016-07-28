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
		<div id="ShowStatus">
		<c:choose>
			<c:when test="${isOverAllMarksUpdated == true}">
				<p style="color: green; font-weight: bold;">Marks Added Successfully </p> 
			</c:when>
			<c:when test="${IncorrectMarks == true}">
				<p style="color: red; font-weight: bold;">Entered Marks Should be less than Total Marks</p>
			</c:when>
			<c:when test="${isOverAllMarksUpdated == false}">
				<p style="color: red; font-weight: bold;">Adding Marks has some issues, Please try latter</p> 
			</c:when>
		</c:choose>
	</div>
		<div  class="row">
			<p style="font-weight: bold;">Course: ${SelectedCourse}</p>
			<p style="font-weight: bold;">Assignment: ${SelectedAssigment}</p>
		</div>
		<div class="row">
			<c:set var="contextPath" value="<%=request.getContextPath() %>" /> 
			<form:form method="post" action="${contextPath}/ProfessorController/EnterMarks" modelAttribute="EnterGrade">
			<table class="table table-bordered">
				 <thead valign="middle">
				    <tr valign="middle">
				      <th>First Name</th>
				      <th>Last Name</th>
				      <th>Marks <p style="font-weight: lighter;">(Should be less than Total Marks)</p></th>
				    </tr>
				  </thead>
				  <tbody>
					<c:forEach items="${EnterGrade.studentList}" var="studentGrade" varStatus="status">
				        <tr>
				            <td>${studentGrade.firstName}</td>
				            <td>${studentGrade.lastName}</td>
				            <c:choose>
								<c:when test="${isOverAllMarksUpdated == true}">
									<td>${studentGrade.marks}</td> 
								</c:when>
								<c:when test="${studentGrade.marks != 0}">
									<td><input name="studentList[${status.index}].marks" value="${studentGrade.marks}"/> 
									
									</td> 
								</c:when>
								<c:otherwise>
									<td><input name="studentList[${status.index}].marks" value="${studentList.marks}"/> 
									</td> 
								</c:otherwise>
							</c:choose>
	
				            
				            <td scope="row" style="visibility:hidden;"><form:input path="studentList[${status.index}].studentId" />
					        	<form:input path="studentList[${status.index}].courseId" />
					        	<form:input path="studentList[${status.index}].assignmentId" /></td>
				        </tr>
		   			</c:forEach>
		   		</tbody>
		   		</table>
		   		<br>
		   		<input type="submit" name="submit" value="Save">
	</form:form>
		</div>
	</div>
</div>

</body>
</html>