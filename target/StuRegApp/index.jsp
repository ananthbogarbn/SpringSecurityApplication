<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

    <body bgcolor="#E6E6FA">
        <table align="center">
            <tr>
                
                <td><a href="register">Register</a>
                </td>
                
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <a href="viewstu">View All Students</a></td>
                </sec:authorize>
                
               
              <!--   <td>
                  <a href="viewstu">View All Students</a></td>
                
            </tr> -->
            <td>
              <a href="login">Edit</a></td>
        </table>
    </body>
</html>