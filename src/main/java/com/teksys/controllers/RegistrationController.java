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
import com.teksys.model.Student;
import com.teksys.model.User;


@Controller
public class RegistrationController {
	 @Autowired
	  public StudentDaoImpl studentDaoImpl;
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("student", new Student());
	    return mav;
	  }
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("student") Student student) {
		  if (student ==null) {
			  return new ModelAndView("unsuccess");
		}
		  studentDaoImpl.register(student);
	  return new ModelAndView("loginWelcome", "username", student.getUsername());
	  }
}
