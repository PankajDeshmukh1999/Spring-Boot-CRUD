package com.student.StudentDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.StudentDemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
