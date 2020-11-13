package com.tcs.employeeapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.service.OrganizationService;
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
	public String updateOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getAllEmployeesOfOrganization(long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

}
