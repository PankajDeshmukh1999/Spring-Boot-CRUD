package com.csi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepositoryImpl;

import exception.ResourceNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepositoryImpl employeeService;

	//insert single record
	@PostMapping("/saveData")
	public ResponseEntity<String> saveData(@RequestBody Employee employee) {
		employeeService.saveData(employee);
		return ResponseEntity.ok("Data Saved");
	}
	
	//Save all data 
	@PostMapping("/saveAllData")
	public ResponseEntity<String> saveMultipleData(@RequestBody List<Employee> employees) {
		employeeService.saveAllData(employees);
		return ResponseEntity.ok("All data saved");
	}

	//get records by specific id
	@GetMapping("/getDataById/{empId}")
	public ResponseEntity<Optional<Employee>> getDataById(@PathVariable("empId") int empId) {
		return ResponseEntity.ok(employeeService.getDataById(empId));
	}

	//Get all records
	@GetMapping("/getAllData")
	public ResponseEntity<List<Employee>> getAllData() {
		return ResponseEntity.ok(employeeService.getAllData());
	}

	//update record 
	@PutMapping("/updateData/{empId}")
	public ResponseEntity<String> updateData(@RequestBody Employee employee, @PathVariable("empId") int empId) {
		employeeService.updateData(empId, employee);
		return ResponseEntity.ok("Data Updated");
	}
	
	//delete record where is .....
	@DeleteMapping("/deleteDataById/{empId}")
	public ResponseEntity<String> deleteDataById(@PathVariable("empId") int empId) {
		employeeService.deleteDataById(empId);
		return ResponseEntity.ok("Data Delete");
	}
	
	//Delete All Records
	@DeleteMapping("/deleteAllData")
	public ResponseEntity<String> deleteAllData() {
		employeeService.deleteAllData();
		return ResponseEntity.ok("empty");
	}
	
	
	//handling exception if id is not found/correct  
	@GetMapping("/empbyid/{empId}")
	public Employee getEmpById(@PathVariable ("empId") int empId) throws ResourceNotFoundException {
		return this.employeeService.getDataById(empId).
				orElseThrow(()-> new ResourceNotFoundException("User not found with id:"));
	}
	
	//Sorting in ASc order
	@GetMapping("/{feild}")
	public List<Employee> getSortAsc(@PathVariable String  feild){
		List<Employee> employee = employeeService.sortAsc(feild);
		return  employee;
	}
		
	
}
