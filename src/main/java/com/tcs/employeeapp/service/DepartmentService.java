package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;

public interface DepartmentService {
	String addDepartment(Department department);
	String updateDepartment(long id);
	String deleteDepartment(long id);
	Optional<Department> findById(long id);
	Optional<List<Department>> getDepartments();
	Optional<List<Employee>> getAllEmployeesOfDepartment(long deptId);
	Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId);
}
