package com.teksys.dao;

import org.springframework.security.core.userdetails.User;

import com.teksys.model.Login;
import com.teksys.model.Student;

public interface StudentDao {
	 void register(Student student);
	  User validateUser(Login login);
}
