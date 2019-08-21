package com.spring.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("opi", "saha"));
		students.add(new Student("piki","saha"));
		
		return students;
	}

}
