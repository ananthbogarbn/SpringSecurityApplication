package com.teksys.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksys.dao.StudentDaoImpl;
import com.teksys.model.Login;
import com.teksys.model.Student;

@Controller
public class LoginController {
	@Autowired
	  StudentDaoImpl studentDaoImpl;
	  @RequestMapping(value = "/log", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		  System.out.println("in login method");
	    ModelAndView mav = new ModelAndView("log");
	    mav.addObject("log", new Login());
	    return mav;
	  }
	  
	/*  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		  System.out.println("in Secured login method");
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }*/
	  
	  
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
		  System.out.println("in loginProcess");
	    ModelAndView mav = null;
	    Student student = studentDaoImpl.validateUser(login);
	    if (null != student) {
	    mav = new ModelAndView("welcome");
	    mav.addObject("Name", student.getUsername());
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }

}