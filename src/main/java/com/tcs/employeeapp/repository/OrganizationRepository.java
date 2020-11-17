package com.tcs.employeeapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;

@Repository("organizationRepository")
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
//	String addOrganization(Organization organization);
//	String updateOrganization(long id, Organization organization);
//	String deleteOrganization(long id);
//	Optional<Organization> findById(long id);
//	Optional<List<Organization>> getOrganizations();
//	Optional<List<Employee>> getAllEmployeesOfOrganization(long orgId);
//	Optional<List<Department>> getAllDepartmentsOfOrganization(long orgId);
}
