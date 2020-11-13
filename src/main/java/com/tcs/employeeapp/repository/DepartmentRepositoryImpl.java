package com.tcs.employeeapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.utils.DBUtils;

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
		Connection connection = DBUtils.getConnection();
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
			DBUtils.closeConnection(connection);
		}
		return "fail";
	}

	@Override
	public String updateDepartment(long id, Department department) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE department SET name = (?) WHERE id = (?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, department.getName());
			ps.setLong(2, department.getId());
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
			DBUtils.closeConnection(connection);
		}
		return "fail";
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
