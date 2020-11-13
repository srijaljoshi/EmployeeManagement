package com.tcs.employeeapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
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
		String sql = "INSERT into employee(id, organizationId, departmentId, name, age, position) VALUES(?,?,?,?,?,?)";
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
			if(result>0) {
				 connection.commit();
				 return "success";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public String updateEmployee(long id, Employee employee) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE employee SET name = (?), age = (?), position = (?) where id=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setInt(2, employee.getAge());
			ps.setString(3, employee.getPosition());
			ps.setLong(4, id);
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
	public String deleteEmployee(long id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROm organization where id=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
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
	public Optional<Employee> findById(long id) {
		Connection connection = DBUtils.getConnection();
		Employee employee = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM employee where id=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setOrganizationId(rs.getLong("organizationId"));
				employee.setDepartmentId(rs.getLong("departmentId"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setPosition(rs.getString("position"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.of(employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		Connection connection = DBUtils.getConnection();
		List<Employee> employees = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM employee";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setOrganizationId(rs.getLong("organizationId"));
				employee.setDepartmentId(rs.getLong("departmentId"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setPosition(rs.getString("position"));
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.of(employees);
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long orgId) {
		Connection connection = DBUtils.getConnection();
		List<Employee> employees = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM employee WHERE organizationId = (?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, orgId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getLong("id"));
				e.setDepartmentId(rs.getLong("departmentId"));
				e.setAge(rs.getInt("age"));
				e.setName(rs.getString("name"));
				e.setOrganizationId(rs.getLong("organizationId"));
				e.setPosition(rs.getString("position"));
				employees.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.of(employees);

	}

}
