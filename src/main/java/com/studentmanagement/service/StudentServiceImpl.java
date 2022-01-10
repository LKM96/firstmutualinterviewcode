package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studentmanagement.exception.ResourceNotFoundException;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;
import com.studentmanagement.web.Dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{
	
@Autowired private StudentRepository student_repository;
	
	
@Override
	public ResponseEntity <List<Student>> getAllStudents(){
		List<Student> student = student_repository.findAll();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<String> saveStudent(Student student){
		student_repository.save(student);
		return new ResponseEntity<String>("saved", HttpStatus.CREATED);
		
	}
	@Override
	public ResponseEntity<String> updateStudent(long id,  StudentDto student_details){
		Student student = student_repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found with id "+id));
		
		student.setFirstName(student_details.getFirstName());
		student.setLastName(student_details.getLastName());
		student.setAge(student_details.getAge());
		student.setMajor(student_details.getMajor());
		
		student_repository.save(student);
		
		return new ResponseEntity<String> ("updated", HttpStatus.ACCEPTED);
		
	}
	
	@Override
	public Student getStudentById(long id) {
		Student student = student_repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found with Id "+id));
		return student;
		
	}
	
	@Override
	public ResponseEntity<String> deleteStudentById(long id){
		student_repository.deleteById(id);
		return new ResponseEntity<String>("Deleted ", HttpStatus.OK);
		
	}

	
}
