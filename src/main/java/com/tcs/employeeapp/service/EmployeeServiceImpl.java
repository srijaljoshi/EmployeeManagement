package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.repository.EmployeeRepository;
import com.tcs.employeeapp.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeService employeeService;
	
	private EmployeeRepository repository = EmployeeRepositoryImpl.getInstance();
	private EmployeeServiceImpl() {}
	
	public static EmployeeService getInstance() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
	
	@Override
	public String addEmployee(Employee employee) {
		return repository.addEmployee(employee);
	}

	@Override
	public String updateEmployee(long id, Employee employee) {
		return repository.updateEmployee(id, employee);
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return repository.deleteEmployee(id);
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return repository.getEmployees();
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return repository.findByOrganizationId(id);
	}

}
