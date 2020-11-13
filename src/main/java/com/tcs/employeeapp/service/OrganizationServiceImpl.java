package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.repository.OrganizationRepository;
import com.tcs.employeeapp.repository.OrganizationRepositoryImpl;

public class OrganizationServiceImpl implements OrganizationService {

	private static OrganizationService organizationService;
	
	private OrganizationRepository repository = OrganizationRepositoryImpl.getInstance();
	
	private OrganizationServiceImpl() {}
	
	public static OrganizationService getInstance() {
		if (organizationService == null) {
			organizationService = new OrganizationServiceImpl();
		}
		return organizationService;
	}
	
	@Override
	public String addOrganization(Organization organization) {
		return repository.addOrganization(organization);
	}

	@Override
	public String updateOrganization(long id, Organization organization) {
		return repository.updateOrganization(id, organization);
	}

	@Override
	public String deleteOrganization(long id) {
		return repository.deleteOrganization(id);
	}

	@Override
	public Optional<Organization> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		return repository.getOrganizations();
	}

	@Override
	public Optional<List<Employee>> getAllEmployeesOfOrganization(long orgId) {
		return repository.getAllEmployeesOfOrganization(orgId);
	}

	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		return repository.getAllDepartmentsOfOrganization(orgId);
	}

}
