package com.tcs.employeeapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.utils.DBUtils;

public class OrganizationRepositoryImpl implements OrganizationRepository {
	
	private static OrganizationRepository organizationRepository;
	
	private OrganizationRepositoryImpl() {}
	
	public static OrganizationRepository getInstance() {
		if (organizationRepository == null) {
			organizationRepository = new OrganizationRepositoryImpl();
		}
		return organizationRepository;
	}

	@Override
	public String addOrganization(Organization organization) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT into organization(id, name, address) VALUES(?,?,?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, organization.getId());
			ps.setString(2, organization.getName());
			ps.setString(3, organization.getAddress());
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
	public String updateOrganization(long id, Organization organization) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE organization SET name = (?), address = (?) where id=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(3, id);
			ps.setString(1, organization.getName());
			ps.setString(2, organization.getAddress());
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
	public String deleteOrganization(long id) {
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
	public Optional<Organization> findById(long id) {
		Connection connection = DBUtils.getConnection();
		Organization organization = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM organization where id=(?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				organization = new Organization();
				organization.setId(rs.getLong("id"));
				organization.setName(rs.getString("name"));
				organization.setAddress(rs.getString("address"));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.of(organization);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		Connection connection = DBUtils.getConnection();
		List<Organization> organizations = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM organization";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Organization organization = new Organization();
				organization.setId(rs.getLong("id"));
				organization.setName(rs.getString("name"));
				organization.setAddress(rs.getString("address"));	
				organizations.add(organization);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.of(organizations);
	}

	@Override
	public Optional<List<Employee>> getAllEmployeesOfOrganization(long orgId) {
		Connection connection = DBUtils.getConnection();
		List<Employee> employees = null;
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

	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		Connection connection = DBUtils.getConnection();
		List<Department> departments = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "SELECT * FROM Department WHERE organizationId = (?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, orgId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setId(rs.getLong("id"));
				dept.setName(rs.getString("name"));
				dept.setOrganizationId(rs.getLong("organizationId"));
				departments.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//fail
			Optional.empty();
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return Optional.of(departments);
	}

}
