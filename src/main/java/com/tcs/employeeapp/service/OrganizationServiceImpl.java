package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository repository;
	
//	private static OrganizationService organizationService;
//	
//	private OrganizationRepository repository = OrganizationRepositoryImpl.getInstance();
//	
//	private OrganizationServiceImpl() {}
//	
//	public static OrganizationService getInstance() {
//		if (organizationService == null) {
//			organizationService = new OrganizationServiceImpl();
//		}
//		return organizationService;
//	}
	
	@Override
	public String addOrganization(Organization organization) {
//		return repository.addOrganization(organization);
		try {
			repository.save(organization);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateOrganization(long id, Organization organization) {
//		return repository.updateOrganization(id, organization);
		try {
			repository.save(organization);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}	
	}

	@Override
	public String deleteOrganization(long id) {
//		return repository.deleteOrganization(id);
		try {
			repository.deleteById(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Organization> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		return Optional.ofNullable(repository.findAll());
	}

	@Transactional
	@Override
	public Optional<List<Employee>> getAllEmployeesOfOrganization(long orgId) {
		Organization organization = repository.findById(orgId).get();
		System.out.println("\n\nFound Organization ----" + organization + "\n\n");
		List<Employee> orgEmployees = organization.getEmployees();
		return Optional.ofNullable(orgEmployees);
	}

	@Transactional
	@Override
	public Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId) {
		Organization organization = findById(orgId).get();
		return Optional.ofNullable(organization.getDepartments());
	}

}
