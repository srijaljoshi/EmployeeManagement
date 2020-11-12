package com.tcs.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;

public class DepartmentRepositoryImpl implements DepartmentRepository{

	private static DepartmentRepository departmentRepository;
	
	private DepartmentRepositoryImpl() {}
	
	public static DepartmentRepository getInstance() {
		if (departmentRepository == null) {
			departmentRepository = new DepartmentRepositoryImpl();
		}
		return departmentRepository;
	}
	
	
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDepartment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getAllEmployeesOfDepartment(long deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

}
