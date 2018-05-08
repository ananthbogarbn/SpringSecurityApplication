package com.teksys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksys.dao.StudentDaoImpl;
import com.teksys.model.Student;

@Controller
public class FunctionalController {
	
	@Autowired
	  StudentDaoImpl studentDaoImpl;
	
	/* @RequestMapping("/viewemp")  
	    public ModelAndView viewemp(){  
	        List<Emp> list=dao.getEmployees();  
	        return new ModelAndView("viewemp","list",list);  
	    }  */
	 @RequestMapping(value="/viewstu" , method = RequestMethod.GET)  
	    public ModelAndView viewemp(){  
		  System.out.println("INSIDE VIEW METHOD");
	        List<Student> list=studentDaoImpl.getStudents();  
	        return new ModelAndView("viewstu","list",list);  
	    }
	 
	 
	  @RequestMapping(value="/deletestu/{username}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable String username){  
		  studentDaoImpl.deleteStudent(username);  
		  System.out.println("Student with username "+username+" is Deleted");
	        return new ModelAndView("deleteSuccess", "username",username);  
	        
	        
	        /*model.addObject("login", new Login());
		    return model;*/
	    }  
	  
	  @RequestMapping(value="/editstu/{username}")  
	    public ModelAndView edit(@PathVariable String username){  
		 System.out.println("inside edit");
	        Student student=studentDaoImpl.getUserName(username);  
	        return new ModelAndView("studenteditform","command",student);  
	    } 
	  
	  @RequestMapping(value="/editstu/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(ModelMap model1 , @ModelAttribute("student") Student student){  
		  System.out.println("trying to update");
		  studentDaoImpl.update(student);  
	        return new ModelAndView("redirect:/index.jsp");  
	    }  
	 
}
