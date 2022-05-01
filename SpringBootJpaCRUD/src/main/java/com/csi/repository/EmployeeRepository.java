package com.csi.repository;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
