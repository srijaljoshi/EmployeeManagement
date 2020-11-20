package com.tcs.employeeapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="organization_springdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	@Id
	private Long id;
	private String name;
	private String address;
	

	@OneToMany(mappedBy = "organization")
	private List<Department> departments = new ArrayList<>();

	@OneToMany(mappedBy = "organization")
	private List<Employee> employees = new ArrayList<>();
	
	
	public Organization(long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}


	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
