 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  
<h1>Students List</h1>  

<table border="2" width="70%" cellpadding="2">  
<tr><th>User Name</th><th>Password</th><th>Address</th><th>Gender</th><th>PhoneNo</th><th>Department</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="student" items="${list}">   
   <tr>  
   <td>${student.username}</td> 
   <td>${student.password}</td> 
  <%--  <td>${student.emailid}</td>  --%> 
   <td>${student.address}</td>  
   <td>${student.gender}</td>  
   <td>${student.phone}</td> 
   <td>${student.department}</td> 
   <td><a href="editstu/${student.username}">Edit</a></td>  
   <td><a href="deletestu/${student.username}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="register">Add New Student</a>  
  <tr>  <td><a href="index.jsp">Home</a>
                        </td></tr>