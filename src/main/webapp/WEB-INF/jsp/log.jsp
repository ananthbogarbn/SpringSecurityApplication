<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<style type="text/css">
		.errorblock{
		color: #ff0000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
		
		}
	</style>
</head>
<body bgcolor="#B9CFCE" onload='document.f.j_phone.focus();'>
	<h1>Student Secured Login Page </h1>
        <c:if test="${not empty error} ">
        	<div class="errorblock">
        		Your login was unsuccessful.<br/>
        		caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
        	</div>
        
        </c:if>
	<form action="j_spring_security_check" name="f" method="post">
				<table align="center">
					<tr>
						<td>User:</td>
						<td><input type="text" name="j_username" value="" required="required">
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="j_password" value="" required="required">
						</td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" name="Submit" value="Submit"></td> 
					</tr>
					<tr align="center">
						<td colspan="2"><input type="reset" name="reset"></td> 
					</tr>
				</table>
			</form>
	
</body>
</html>