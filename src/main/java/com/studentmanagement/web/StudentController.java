package com.studentmanagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.exception.ResourceNotFoundException;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;

@RestController
@RequestMapping("student/api/v1")
public class StudentController {
	@Autowired private StudentRepository student_repository;
	
	
	@GetMapping (value = "allstudents", produces = {"application/json", "application/xml"})
	public ResponseEntity <List<Student>> getAllStudents(){
		List<Student> student = student_repository.findAll();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}
	
	@PostMapping(value="save-student", consumes = {"application/json", "application/xml"})
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		student_repository.save(student);
		return new ResponseEntity<String>("saved", HttpStatus.CREATED);
		
	}
	
	@PatchMapping(value= "update-student/{id}", consumes = {"application/json", "application/xml"})
	public ResponseEntity<String> updateStudent(@PathVariable("id") long id, @RequestBody Student student_details){
		Student student = student_repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found with id "+id));
		
		student.setFirstName(student_details.getFirstName());
		student.setLastName(student_details.getLastName());
		student.setAge(student_details.getAge());
		student.setMajor(student_details.getMajor());
		
		student_repository.save(student);
		
		return new ResponseEntity<String> ("updated", HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="studentById/{id}", produces = {"application/json", "application/xml"})
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
		Student student = student_repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found with Id "+id));
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	@DeleteMapping("delete-studentById/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id){
		student_repository.deleteById(id);
		return new ResponseEntity<String>("Deleted ", HttpStatus.OK);
		
	}
}
