package com.tcs.employeeapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {	
	private Long id;
	private Long organizationId;
	private String name;
	private List<Employee> employees;
	@Override
	public String toString() {
		return "Department [id=" + id + ", organizationId=" + organizationId + ", name=" + name + "]";
	}
	
	
}
