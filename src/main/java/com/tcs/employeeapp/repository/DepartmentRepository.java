package com.tcs.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
//	String addDepartment(Department department);
//	String updateDepartment(long id, Department department);
//	String deleteDepartment(long id);
//	Optional<Department> findById(long id);
//	Optional<List<Department>> getDepartments();
//	Optional<List<Employee>> getAllEmployeesOfDepartment(long deptId);
//	Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId);
}
