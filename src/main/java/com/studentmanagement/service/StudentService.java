package com.studentmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.studentmanagement.model.Student;
import com.studentmanagement.web.Dto.StudentDto;

public interface StudentService {
	ResponseEntity<List<Student>> getAllStudents();
	ResponseEntity<String> saveStudent(Student student);
	ResponseEntity<String> updateStudent( long id, StudentDto student_details);
	Student getStudentById(long id);
	ResponseEntity<String> deleteStudentById(long id);
	
		
}
