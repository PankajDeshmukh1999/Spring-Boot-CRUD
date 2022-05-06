package com.student.StudentDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.StudentDemo.entity.Student;
import com.student.StudentDemo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/saveData")
	public ResponseEntity<String> saveData(@RequestBody Student student) {
		service.saveData(student);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/saveAllData")
	public ResponseEntity<String> saveMultipleData(@RequestBody List<Student> student) {
		service.saveAllData(student);
		return ResponseEntity.ok("All data saved");
	}
	
	@GetMapping("/getAllData")
	public ResponseEntity<List<Student>> getAllData() {
		return ResponseEntity.ok(service.getAllData());
	}
	
	@GetMapping("/getDataById/{id}")
	public ResponseEntity<Optional<Student>> getDataById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.getDataById(id));
	}
}
