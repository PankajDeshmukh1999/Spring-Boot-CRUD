package com.student.StudentDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.StudentDemo.entity.Student;
import com.student.StudentDemo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public void saveData(Student student) {
		repository.save(student);
	}
	
	public void saveAllData(List<Student> employees) {
		repository.saveAll(employees);
	}
	
	public List<Student> getAllData() {
		return (List<Student>) repository.findAll();
	}
	
	public Optional<Student> getDataById(int id) {
		return repository.findById(id);
	}
}
