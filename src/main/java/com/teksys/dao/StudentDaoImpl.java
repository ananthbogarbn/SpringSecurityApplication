package com.teksys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.teksys.model.Login;
import com.teksys.model.Student;

public class StudentDaoImpl {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbctemplate;

	public void register(Student student) {
		String sql = "insert into student values(?,?,?,?,?,?)";
		jdbctemplate.update(sql, new Object[] { student.getUsername(), student.getPassword(), student.getAddress(),
				student.getGender(), student.getPhone(), student.getDepartment() });

		String sql1 = "insert into users values(?,?,?)";
		jdbctemplate.update(sql1, new Object[] { student.getUsername(), student.getPassword(), true });

	}

	public Student validateUser(Login login) {
		String sql = "select * from student where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";
		List<Student> users = jdbctemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	/*
	 * public List<Student> getstudents() { String sql = "select * from student";
	 * 
	 * List<Student> studentlist = jdbctemplate.query(sql, new
	 * ResultSetExtractor<List<Student>>() { public List<Student>
	 * extractData(ResultSet rs) throws SQLException, DataAccessException {
	 * List<Student> list = new ArrayList<Student>(); while (rs.next()) { Student
	 * student = new Student();
	 * 
	 * student.setUsername(rs.getString(1)); student.setPassword(rs.getString(2));
	 * student.setAddress(rs.getString(3)); student.setGender(rs.getString(4));
	 * student.setPhone(rs.getString(5)); student.setDepartment(rs.getString(6));
	 * 
	 * list.add(student); } return list; }
	 * 
	 * }); return studentlist; }
	 */
	public List<Student> getStudents() {
		return jdbctemplate.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student student = new Student();

				student.setUsername(rs.getString(1));
				student.setPassword(rs.getString(2));
				student.setAddress(rs.getString(3));
				student.setGender(rs.getString(4));
				student.setPhone(rs.getString(5));
				student.setDepartment(rs.getString(6));
				return student;
			}
		});
	}

	// Updating a particular Student
	public void updateStudent(Student student) {
		String sql = "update student set username=?, password=?, address=?, gender=?, phone=?,department=? where username=?";
		jdbctemplate.update(sql, new Object[] { student.getUsername(), student.getPassword(), student.getAddress(),
				student.getGender(), student.getPhone(), student.getDepartment(), student.getUsername() });
	}

	// Deletion of a particular Student
	public void deleteStudent(String username) {
		String sql = "delete from student where username=?";
		jdbctemplate.update(sql, new Object[] { username });

		String sql1 = "delete from users where username=?";
		jdbctemplate.update(sql1, new Object[] { username });

		/*
		 * String sql2="delete from authorities where username=?";
		 * jdbctemplate.update(sql2 , new Object[] {username});
		 */

	}

	public void update(Student student) {

		String sql = "update student set username=?, password=? ,  address=? , gender=? , phone=? , department=? where username=?";
		jdbctemplate.update(sql, new Object[] { student.getUsername(), student.getPassword(), student.getAddress(),
				student.getGender(), student.getPhone(), student.getDepartment(), student.getUsername() });

	}

	public Student getUserName(String username) {
		String sql = "select * from student where username=?";
		return jdbctemplate.queryForObject(sql, new Object[] { username },
				new BeanPropertyRowMapper<Student>(Student.class));
	}
}

class UserMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		Student student = new Student();
		student.setUsername(rs.getString(1));
		student.setPassword(rs.getString(2));
		student.setAddress(rs.getString(3));
		student.setGender(rs.getString(4));
		student.setPhone(rs.getString(5));
		student.setDepartment(rs.getString(6));

		return student;
	}
}
