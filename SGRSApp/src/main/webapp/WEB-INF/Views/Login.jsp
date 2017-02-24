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

<body>
	<div><jsp:include page="Header.jsp" /></div>
	<div style="color: red;" class="row">${errorMsg}</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-lock"></span> Login</div>
                <div class="panel-body">
                   <form name="LoginForm" action="<%=request.getContextPath()%>/AccountController/Login"	method="post">
                    <div class="form-group">
                        <div class="col-mid-4">
                            <input type="text" class="form-control" name="userName" id="userName" placeholder="UserName">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-mid-4">
                            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="">
                                 <input type="submit" name="submit" value="Login" class="btn btn-success btn-sm btn-block">
                        </div>
                    </div>
                    </form>
                </div>
                <div class="panel-footer">
                    Click <a href="https://cloud.githubusercontent.com/assets/7827378/21064893/7d41d1b6-be2b-11e6-8459-b9f9f247f3fe.PNG">here</a> to see credentials to operate this website</div>
            </div>
        </div>
    </div>
</div>

    <%-- <form name="LoginForm" action="<%=request.getContextPath()%>/AccountController/Login"	method="post">
		<input type="text" name="userName" id="userName" placeholder="UserName"> 
		<input type="password" name="password" id="password" placeholder="Password">
		<input type="submit" name="submit" value="Login" class="btn btn-block">
	</form> --%>

</body>
</html>