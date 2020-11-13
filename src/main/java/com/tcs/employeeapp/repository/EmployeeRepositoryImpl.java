package com.tcs.employeeapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.utils.DBUtils;

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
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT into employee(id, organizationId, departmentId, name, age, position) VALUES(?,?,?,?,?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, employee.getId());
			ps.setLong(2, employee.getOrganizationId());
			ps.setLong(3, employee.getDepartmentId());
			ps.setString(4, employee.getName());
			ps.setInt(5, employee.getAge());
			ps.setString(6, employee.getPosition());
			
			result = ps.executeUpdate();
			if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		} finally {
			DBUtils.closeConnection(connection);
		}

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
