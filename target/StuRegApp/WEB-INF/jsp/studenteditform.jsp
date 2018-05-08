<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Student</h1>  
       <form:form method="POST" action="editsave" >    
        <table >    
        <tr>  
        <td>User Name :</td>    
         <td><form:input  path="username" readonly="true"/></td>  
         </tr>   
         <tr>    
          <td>Password : </td>   
          <td><form:input path="password"  readonly="true"/></td>  
         </tr>    
     
         <tr>    
          <td>Address :</td>    
          <td><form:input path="address" /></td>  
         </tr>  
          <tr>    
          <td>Gender :</td>    
          <td><form:input path="gender" /></td>  
         </tr> 
          <tr>    
          <td>Phone :</td>    
          <td><form:input path="phone" /></td>  
         </tr> 
          <tr>    
        <td>Department :</td>    
          <td><form:input path="department" /></td>  
         
         </tr>  
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>