package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Employee;

public interface EmployeeService {
	String addEmployee(Employee employee);
	String updateEmployee(long id, Employee employee);
	String deleteEmployee(long id);
	Optional<Employee> findById(long id);
	Optional<List<Employee>> getEmployees();
	Optional<List<Employee>> findByOrganizationId(long id);
}
