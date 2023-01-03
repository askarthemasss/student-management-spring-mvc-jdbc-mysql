package com.askar.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.askar.sm.DAO.StudentDAO;
import com.askar.sm.DAO.StudentDAOImpl;
import com.askar.sm.api.Student;

@Controller
public class StudentController {
	
	// since we used @Repository in impl class, we can use @Autowired
	//	StudentDAO studentDAO = new StudentDAOImpl();
	@Autowired
	private StudentDAO studentDAO;		// Injecting the DAO Object
	
//	@RequestMapping(value = "/showStudent", method = RequestMethod.GET)
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		// call the DAO method to get data
		List<Student> studentList = studentDAO.loadStudents();	// DAO call
		
		// Check if data is coming
		for(Student tempStudent : studentList) {
			System.out.println(tempStudent);
		}
		
		model.addAttribute("students", studentList);
		
		return "student-list";
	}

}
