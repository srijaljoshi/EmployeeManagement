package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.repository.DepartmentRepository;
import com.tcs.employeeapp.repository.OrganizationRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private OrganizationService organizationService;
		
//	private static DepartmentService departmentService;
//	
//	// dao singleton instance variable
//	private DepartmentRepository departmentRepository = DepartmentRepositoryImpl.getInstance();
//	
//	private DepartmentServiceImpl() {}
//	public static DepartmentService getInstance() {
//		if (departmentService == null) {
//			departmentService = new DepartmentServiceImpl();
//		}
//		return departmentService;
//	}
//	
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
		return departmentRepository.deleteDepartment(id);
	}

	@Override
	public Optional<Department> findById(long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		return departmentRepository.getDepartments();
	}

	@Override
	public Optional<List<Employee>> getAllEmployeesOfDepartment(long deptId) {
		return departmentRepository.getAllEmployeesOfDepartment(deptId);
	}

	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		// using this since it was already implemented 
		return organizationService.getAllDepartmentsOfOrganization(orgId);
	}

}
