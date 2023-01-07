package com.askar.sm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.askar.sm.api.Student;
import com.askar.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

//	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Student> loadStudents() {
		
		// get data from db and add to below ArrayList and return it
		// when the loadStudents() method is called from controller, studentList will be returned.
		//		List<Student> studentList = new ArrayList<Student>();
		
		String sql = "SELECT * FROM students";
		
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		
		
		return theListOfStudent;
	}

}
