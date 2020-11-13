package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;

public interface OrganizationService {
	String addOrganization(Organization organization);
	String updateOrganization(long id, Organization organization);
	String deleteOrganization(long id);
	Optional<Organization> findById(long id);
	Optional<List<Organization>> getOrganizations();
	Optional<List<Employee>> getAllEmployeesOfOrganization(long orgId);
	Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId);
}
