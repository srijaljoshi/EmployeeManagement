package com.tcs.employeeapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.utils.DBUtils;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{

	@Autowired
	private DBUtils dbUtils;
	
//	private static DepartmentRepository departmentRepository;
//	
//	private DepartmentRepositoryImpl() {}
//	
//	public static DepartmentRepository getInstance() {
//		if (departmentRepository == null) {
//			departmentRepository = new DepartmentRepositoryImpl();
//		}
//		return departmentRepository;
//	}
	
	
	@Override
	public String addDepartment(Department department) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO department(id, organizationId, name) VALuES(?,?,?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, department.getId());
			ps.setLong(2, department.getOrganizationId());
			ps.setString(3, department.getName());
			result = ps.executeUpdate();
			if (result > 0) {
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
			dbUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public String updateDepartment(long id, Department department) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE department SET name = (?) WHERE id = (?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, department.getName());
			ps.setLong(2, id);
			result = ps.executeUpdate();
			if (result > 0) {
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
			dbUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public String deleteDepartment(long id) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROm department WHERE id = (?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			result = ps.executeUpdate();
			if (result > 0) {
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
			dbUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public Optional<Department> findById(long id) {
		Connection connection = dbUtils.getConnection();
		Department department = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM department where id=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				department = new Department();
				department.setId(rs.getLong("id"));
				department.setOrganizationId(rs.getLong("organizationId"));
				department.setName(rs.getString("name"));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.of(department);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		Connection connection = dbUtils.getConnection();
		List<Department> departments = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM department";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Department department = new Department();
				department.setId(rs.getLong("id"));
				department.setOrganizationId(rs.getLong("organizationId"));
				department.setName(rs.getString("name"));
				departments.add(department);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.of(departments);
	}

	@Override
	public Optional<List<Employee>> getAllEmployeesOfDepartment(long deptId) {
		Connection connection = dbUtils.getConnection();
		List<Employee> employees = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM employee WHERE departmentId=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, deptId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				emp.setDepartmentId(rs.getLong("departmentId"));
				emp.setOrganizationId(rs.getLong("organizationId"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setPosition(rs.getString("position"));
				employees.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.of(employees);
	}

	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		// Already implemented in OrganizationRepositoryImpl
		return null;
	}

}
