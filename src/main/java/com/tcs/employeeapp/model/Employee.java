package com.tcs.employeeapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_springdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private Long id;
//	private Long organizationId;
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;
	
//	private Long departmentId;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	private String name;
	private int age;
	private String position;
	
	
}
