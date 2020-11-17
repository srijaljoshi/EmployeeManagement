package com.tcs.employeeapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="department_springdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {	
	@Id
	private Long id;
	private Long organizationId;
	private String name;
	@Transient
	private List<Employee> employees;
	
	// custom constructor
	public Department(long id, long oid, String name) {
		this.id = id;
		this.organizationId = oid;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", organizationId=" + organizationId + ", name=" + name + "]";
	}
	
	
}
