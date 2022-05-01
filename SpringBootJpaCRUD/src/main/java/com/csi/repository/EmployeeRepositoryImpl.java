package com.csi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.csi.model.Employee;

@Service
public class EmployeeRepositoryImpl {

	@Autowired
	EmployeeRepository employeeRepository;

	public void saveData(Employee employee) {
		employeeRepository.save(employee);
	}

	public void saveAllData(List<Employee> employees) {
		employeeRepository.saveAll(employees);
	}

	public Optional<Employee> getDataById(int empId) {
		return employeeRepository.findById(empId);
	}

	public List<Employee> getAllData() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public void updateData(int empId, Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteDataById(int empId) {
		employeeRepository.deleteById(empId);
	}

	public void deleteAllData() {
		employeeRepository.deleteAll();
	}

	public List<Employee> sortAsc(String feild){
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,feild));
	}


	
}
