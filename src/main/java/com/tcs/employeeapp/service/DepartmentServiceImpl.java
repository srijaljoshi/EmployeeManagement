package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.repository.DepartmentRepository;
import com.tcs.employeeapp.repository.DepartmentRepositoryImpl;

public class DepartmentServiceImpl implements DepartmentService {

	private static DepartmentService departmentService;
	
	// dao singleton instance variable
	private DepartmentRepository departmentRepository = DepartmentRepositoryImpl.getInstance();
	
	private DepartmentServiceImpl() {}
	public static DepartmentService getInstance() {
		if (departmentService == null) {
			departmentService = new DepartmentServiceImpl();
		}
		return departmentService;
	}
	
	@Override
	public String addDepartment(Department department) {
		return departmentRepository.addDepartment(department);
	}

	@Override
	public String updateDepartment(long id, Department department) {
		return departmentRepository.updateDepartment(id, department);
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
