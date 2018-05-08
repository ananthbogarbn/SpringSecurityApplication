<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#C3AFD8">
	<table>
            <tr>
             <td><h1>Welcome ${username}!!! you successfully logged in</h1></td> 
               <%-- <td><h1>Welcome <sec:authentication property="studentname"/>!!! you successfully logged in</h1></td> --%>
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
                <td><a href="login">Home</a>
                  <a href="register">Another Response</a>
                </td>
           
                  <%-- <a href="editstu/${student.username}">Edit</a> --%>
                </td></tr>
</body>
</html>