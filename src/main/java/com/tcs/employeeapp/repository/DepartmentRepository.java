package com.tcs.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;

public interface DepartmentRepository {
	String addDepartment(Department department);
	String updateDepartment(long id, Department department);
	String deleteDepartment(long id);
	Optional<Department> findById(long id);
	Optional<List<Department>> getDepartments();
	Optional<List<Employee>> getAllEmployeesOfDepartment(long deptId);
	Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId);
}
