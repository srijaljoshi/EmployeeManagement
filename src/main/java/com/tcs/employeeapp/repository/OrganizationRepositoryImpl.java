package com.tcs.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.service.OrganizationService;

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
		// TODO Auto-generated method stub
		return null;
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
