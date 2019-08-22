package com.spring.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("opi", "saha"));
		students.add(new Student("piki","saha"));
		students.add(new Student("ma","love"));
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNOtFoundException("student not found: " + studentId);
			
		}
		return students.get(studentId);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNOtFoundException exc){
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMassage(exc.getMessage());
		errorResponse.setTimestam(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMassage("wrong parameter");
		errorResponse.setTimestam(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}

}
