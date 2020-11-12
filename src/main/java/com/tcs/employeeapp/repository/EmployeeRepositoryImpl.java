package com.tcs.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.service.DepartmentService;
import com.tcs.employeeapp.service.DepartmentServiceImpl;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private static EmployeeRepository employeeRepository;
	
	private EmployeeRepositoryImpl() {}
	
	public static EmployeeRepository getInstance() {
		if (employeeRepository == null) {
			employeeRepository = new EmployeeRepositoryImpl();
		}
		return employeeRepository;
	}
	
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
