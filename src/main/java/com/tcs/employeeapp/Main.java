package com.tcs.employeeapp;

import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.service.OrganizationService;
import com.tcs.employeeapp.service.OrganizationServiceImpl;

public class Main {
	public static void main(String[] args) {
		
		boolean running = true;
		while (running) {
			
		}
		
		
		
		OrganizationService organizationService = OrganizationServiceImpl.getInstance();
		Organization o1 = new Organization();
		o1.setId(1L);
		o1.setName("Apple Inc.");
		o1.setAddress("Palo Alto");
		String result = organizationService.addOrganization(o1);
		
		if ("success".equalsIgnoreCase(result)) {
			System.out.println("Added Successfully");
		} else {
			System.out.println("Failed to add");
		}
	}
	
	private static void showEmployeeMenu() {
		
	}
	
	
}
