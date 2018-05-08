<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body bgcolor="#EFC996">
        <h1 align="center">Registration Page</h1>
            <form:form id="regForm" modelAttribute="student" action="registerProcess" method="post">
                <table align="center">
                
                     <tr>
                        <td>
                            <form:label path="username">StudentName</form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" maxlength="45" placeholder="Enter User Name"/>
                        </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" maxlength="45" placeholder="password"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <form:label path="address">Address</form:label>
                        </td>
                        <td>
                            <form:input path="address" name="address" id="address" maxlength="45"/>
                        </td>
                    </tr>
                   
                    
                   <tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="male" size="10">Male
						<input type="radio" name="gender" value="Female" size="10">Female</td>
				</tr>
                   <tr>
                        <td>
                            <form:label path="phone">Phone</form:label>
                        </td>
                        <td>
                            <form:input path="phone" name="phone" id="phone" maxlength="45"/>
                        </td>
                    </tr>
                    
                    <tr>
					<td>Department</td>
					<td><select name="department">
							<option value="Not Selected" selected>select..</option>
							<option value="Electronics and communication Engineering">ECE</option>
							<option value="Computer science Engineering">CSE</option>
							<option value="Mechanical Engineering">ME</option>
							<option value="Civil Engineering">CV</option>
					</select></td>
				</tr>
                    
                   
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                    
                    
                        <td></td>
                        <td><a href="index.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>
        </html>