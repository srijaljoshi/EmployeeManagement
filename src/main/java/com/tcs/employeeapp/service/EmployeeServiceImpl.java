package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

//	private static EmployeeService employeeService;
//	
//	private EmployeeRepository repository = EmployeeRepositoryImpl.getInstance();
//	private EmployeeServiceImpl() {}
//	
//	public static EmployeeService getInstance() {
//		if (employeeService == null) {
//			employeeService = new EmployeeServiceImpl();
//		}
//		return employeeService;
//	}

	@Override
	public String addEmployee(Employee employee) {
//		return repository.addEmployee(employee);
		try {
			repository.save(employee);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateEmployee(long id, Employee employee) {
		try {
			repository.save(employee);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		try {
			repository.deleteById(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
//		return repository.findByOrganizationId(id);
		return Optional.ofNullable(null);
	}

}
