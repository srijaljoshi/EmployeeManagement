package com.tcs.employeeapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.service.DepartmentService;
import com.tcs.employeeapp.service.DepartmentServiceImpl;
import com.tcs.employeeapp.service.EmployeeService;
import com.tcs.employeeapp.service.EmployeeServiceImpl;
import com.tcs.employeeapp.service.OrganizationService;
import com.tcs.employeeapp.service.OrganizationServiceImpl;

public class Main {

	private static InputStreamReader isr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);

	public static void main(String[] args) {

		OrganizationService organizationService = OrganizationServiceImpl.getInstance();
		DepartmentService departmentService = DepartmentServiceImpl.getInstance();
		EmployeeService employeeService = EmployeeServiceImpl.getInstance();
		
		boolean running = true;
		String choice = "";
		while (running) {
			showMenu();

			System.out.println("Enter your choice: ");
			try {
				choice = br.readLine();
				
				switch (choice) {
				case "1":
					showOrganizationMenu();
					organizationActions(organizationService);

					break;
				
				case "2":
					showDepartmentMenu();
					departmentActions(departmentService);
				
				case "3":
					showEmployeeMenu();
					employeeActions(employeeService);
					break;
				
				case "q":
					running = false;
					break;
				default:
					System.err.println("Invalid choice. Please try again or hit q to quit!");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	private static void organizationActions(OrganizationService organizationService) {
		System.out.println("Enter your choice");
		String choice = "";
		
		try {
			choice = br.readLine();
			
			switch (choice) {
			case "1":
				System.out.println("Enter organization details to add in the following order: (id, name, address)");
				try {
					long id = Long.parseLong(br.readLine());
					String name = br.readLine();
					String address = br.readLine();
					Organization organization = new Organization(id, name, address);
					String result = organizationService.addOrganization(organization);
					
					if ("success".equalsIgnoreCase(result)) {
						System.out.println("<Organization> Added Successfully");
					} else {
						System.out.println("<Organization> Failed to add");
					}
					
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case "2":
				System.out.println("Enter the organization id to update: ");
		
				try {
					long id = Long.parseLong(br.readLine());
					Optional<Organization> optional = organizationService.findById(id);
					if (optional.isPresent()) {
						System.out.println("Enter new details:(name, address) ");
						Organization org = new Organization();
						String name = br.readLine();
						String address = br.readLine();
						org.setName(name);
						org.setAddress(address);
						String result = organizationService.updateOrganization(id, org);
						if ("success".equalsIgnoreCase(result)) {
							System.out.println("<Organization> Updated Successfully");
						} else {
							System.out.println("<Organization> Failed to updated");
						}
						
					} else {
						System.out.println("Given ID doesn't exist. Please try again!");
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				
				break;
				
			case "3":
				System.out.println("Enter the ID of the organization to delete: ");
				try {
					long id = Long.parseLong(br.readLine());
					String result = organizationService.deleteOrganization(id);
					
					if ("success".equalsIgnoreCase(result)) {
						System.out.println("<Organization> Deleted Successfully");
					} else {
						System.out.println("<Organization> Failed to delete");
					}
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
				
			case "4":
				System.out.println("Enter the ID of the organization to fetch details: ");
				try {
					long id = Long.parseLong(br.readLine());
					Optional<Organization> optional = organizationService.findById(id);
					if (optional.isPresent()) {
						Organization organization = optional.get();
						System.out.println("Found the organization: " + organization);
					} else {
						System.out.println("Given ID doesn't exist. Please try again!");
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				
				break;
				
			case "5":
				System.out.println("Getting all organizations in the db... ");
				Optional<List<Organization>> optionalOrg = organizationService.getOrganizations();
				if (optionalOrg.isPresent()) {
					List<Organization> organizations = optionalOrg.get();
					System.out.println("---------------------------------------------------------");
					for (Iterator<Organization> iterator = organizations.iterator(); iterator.hasNext();) {
						Organization organization = iterator.next();
						System.out.println(organization);
					}
					System.out.println("---------------------------------------------------------");
				}
				break;
				
			case "6":
				System.out.println("Enter the organization ID to retrive the employees of that organization: ");
				try {
					long orgId = Long.parseLong(br.readLine());
					Optional<List<Employee>> allEmployeesOptional = organizationService.getAllEmployeesOfOrganization(orgId);
					if (allEmployeesOptional.isPresent()) {
						List<Employee> employees = allEmployeesOptional.get();
						if (employees.size() > 0) {
							System.out.println("-------------------Employee Details--------------------");
							for (Employee employee : employees) {
								System.out.println(employee);
							}
							System.out.println("---------------------------------------------------------");
						} else {
						System.out.println("No employees exist currently in the organization");
						}
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
				
			case "7":
				System.out.println("Enter the organization ID to retrive the departments of that organization: ");
				try {
					long orgId = Long.parseLong(br.readLine());
					Optional<List<Department>> allDepOptional = organizationService.getAllDepartmentsOfOrganization(orgId);
					if (allDepOptional.isPresent()) {
						List<Department> departments = allDepOptional.get();
						if (departments.size() > 0) {
							System.out.println("-------------------Department Details--------------------");
							for (Department dept: departments) {
								System.out.println(dept);
							}
							System.out.println("---------------------------------------------------------");
						}
						else {
						System.out.println("No departments exist currently in the organization");
						}
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			} // end switch
			
		} // end try
		catch (IOException e2) {
			e2.printStackTrace();
		}
			
	}

	private static void departmentActions(DepartmentService departmentService) {
		System.out.println("Enter your choice");
		String choice = "";
		
		try {
			choice = br.readLine();
			switch (choice) {
			case "1":
				System.out.println("Enter Department details to add in the following order: (id, organizationId, name)");
				try {
					long id = Long.parseLong(br.readLine());
					long orgId = Long.parseLong(br.readLine());
					String name = br.readLine();
					Department department = new Department(id, orgId, name);
					String result = departmentService.addDepartment(department);
					
					if ("success".equalsIgnoreCase(result)) {
						System.out.println("<Department> Added Successfully");
					} else {
						System.out.println("<Department> Failed to add");
					}
					
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case "2":
				System.out.println("Enter the  id to update: ");
		
				try {
					long id = Long.parseLong(br.readLine());
					Optional<Department> optional = departmentService.findById(id);
					if (optional.isPresent()) {
						System.out.println("Enter new details:(name) ");
						Department department = new Department();
						String name = br.readLine();
						department.setName(name);
						String result = departmentService.updateDepartment(id, department);
						if ("success".equalsIgnoreCase(result)) {
							System.out.println("<department> Updated Successfully");
						} else {
							System.out.println("<department> Failed to updated");
						}
						
					} else {
						System.out.println("Given ID doesn't exist. Please try again!");
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				
				break;
				
			case "3":
				System.out.println("Enter the ID of the department to delete: ");
				try {
					long id = Long.parseLong(br.readLine());
					String result = departmentService.deleteDepartment(id);
					
					if ("success".equalsIgnoreCase(result)) {
						System.out.println("<Department> Deleted Successfully");
					} else {
						System.out.println("<Department> Failed to delete");
					}
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
				
			case "4":
				System.out.println("Enter the ID of the department to fetch details: ");
				try {
					long id = Long.parseLong(br.readLine());
					Optional<Department> optional = departmentService.findById(id);
					if (optional.isPresent()) {
						Department department = optional.get();
						System.out.println("Found the department: " + department);
					} else {
						System.out.println("Given ID doesn't exist. Please try again!");
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				
				break;
				
			case "5":
				System.out.println("Getting all departments in the db... ");
				Optional<List<Department>> optionalOrg = departmentService.getDepartments();
				if (optionalOrg.isPresent()) {
					List<Department> departments = optionalOrg.get();
					System.out.println("---------------------------------------------------------");
					for (Iterator<Department> iterator = departments.iterator(); iterator.hasNext();) {
						Department department = iterator.next();
						System.out.println(department);
					}
					System.out.println("---------------------------------------------------------");
				}
				break;
				
			case "6":
				System.out.println("Enter the department ID to retrive the employees of that department: ");
				try {
					long orgId = Long.parseLong(br.readLine());
					Optional<List<Employee>> allEmployeesOptional = departmentService.getAllEmployeesOfDepartment(orgId);
					if (allEmployeesOptional.isPresent()) {
						List<Employee> employees = allEmployeesOptional.get();
						System.out.println("-------------------Employee Details--------------------");
						for (Employee employee : employees) {
							System.out.println(employee);
						}
						System.out.println("---------------------------------------------------------");
	
					} else {
						System.out.println("No employees exist currently in the department");
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
				
			case "7":
				System.out.println("Enter the department ID to retrive the departments of that department: ");
				try {
					long orgId = Long.parseLong(br.readLine());
					Optional<List<Department>> allDepOptional = departmentService.getAllDepartmentsOfOrganization(orgId);
					if (allDepOptional.isPresent()) {
						List<Department> departments = allDepOptional.get();
						System.out.println("-------------------Department Details--------------------");
						for (Department dept: departments) {
							System.out.println(dept);
						}
						System.out.println("---------------------------------------------------------");
	
					} else {
						System.out.println("No employees exist currently in the department");
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
				break;
				
			default:
				break;
			} // end switch
		 } 
		catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private static void employeeActions(EmployeeService employeeService) throws IOException {
		System.out.println("Enter your choice");
		String choice = "";
		choice = br.readLine();
		switch (choice) {
		case "1":
			System.out.println("Enter employee details in the following order: (id, organizationId, departmentId, name, age, position)");
			try {
				long id = Long.parseLong(br.readLine());
				long orgId = Long.parseLong(br.readLine());
				long deptId = Long.parseLong(br.readLine());
				String name = br.readLine();
				int age = Integer.parseInt(br.readLine());
				String position = br.readLine();
				
				Employee employee = new Employee(id, orgId, deptId, name, age, position);
				String result = employeeService.addEmployee(employee);
				if ("success".equalsIgnoreCase(result)) {
					System.out.println("<Employee> Added Successfully");
				} else {
					System.out.println("<Employee> Failed to add");
				}
				
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			break;
			
		case "2":
			System.out.println("Enter the  id to update: ");
	
			try {
				long id = Long.parseLong(br.readLine());
				Optional<Employee> optional = employeeService.findById(id);
				if (optional.isPresent()) {
					System.out.println("Enter new details:(name, age, position) ");
					Employee employee = new Employee();
					String name = br.readLine();
					int age = Integer.parseInt(br.readLine());
					String position = br.readLine();
					employee.setName(name); 
					employee.setAge(age);
					employee.setPosition(position);
					
					String result = employeeService.updateEmployee(id, employee);
					
					if ("success".equalsIgnoreCase(result)) {
						System.out.println("<employee> Updated Successfully");
					} else {
						System.out.println("<employee> Failed to updated");
					}
					
				} else {
					System.out.println("Given ID doesn't exist. Please try again!");
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			break;
			
		case "3":
			System.out.println("Enter the ID of the employee to delete: ");
			try {
				long id = Long.parseLong(br.readLine());
				String result = employeeService.deleteEmployee(id);
				
				if ("success".equalsIgnoreCase(result)) {
					System.out.println("<Employee> Deleted Successfully");
				} else {
					System.out.println("<Employee> Failed to delete");
				}
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			break;
			
		case "4":
			System.out.println("Enter the ID of the employee to fetch details: ");
			try {
				long id = Long.parseLong(br.readLine());
				Optional<Employee> optional = employeeService.findById(id);
				if (optional.isPresent()) {
					Employee employee = optional.get();
					System.out.println("Found the employee: " + employee);
				} else {
					System.out.println("Given ID doesn't exist. Please try again!");
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			break;
			
		case "5":
			System.out.println("Getting all employees in the db... ");
			Optional<List<Employee>> optionalOrg = employeeService.getEmployees();
			if (optionalOrg.isPresent()) {
				List<Employee> employees = optionalOrg.get();
				System.out.println("---------------------------------------------------------");
				for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
					Employee employee = iterator.next();
					System.out.println(employee);
				}
				System.out.println("---------------------------------------------------------");
			}
			break;
		
		case "6":
			System.out.println("Enter the organization ID to retrive the employees of that organization: ");
			try {
				long orgId = Long.parseLong(br.readLine());
				Optional<List<Employee>> allEmployeesOptional = employeeService.findByOrganizationId(orgId);
				if (allEmployeesOptional.isPresent()) {
					List<Employee> employees = allEmployeesOptional.get();
					if (employees.size() > 0) {
						System.out.println("-------------------Employee Details--------------------");
						for (Employee employee : employees) {
							System.out.println(employee);
						}
						System.out.println("---------------------------------------------------------");
					} else {
					System.out.println("No employees exist currently in the organization");
					}
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}

	}

	private static void showMenu() {
		System.out.println("******************************************");
		System.out.println(" 1. Organization Management\n" + " 2. Department Management\n" + " 3. Employee Management");
		System.err.println("PRESS q to quit!");
		System.out.println("******************************************\n");

	}
	

	private static void showOrganizationMenu() {
		System.out.println("******************************************");
		System.out.println(" 1. addOrganization(Organization organization);\n"
				+ " 2. updateOrganization(long id, Organization organization);\n"
				+ " 3. deleteOrganization(long id);\n"
				+ " 4. findById(long id);\n"
				+ " 5. getOrganizations();\n"
				+ " 6. getAllEmployeesOfOrganization(long orgId);\n"
				+ " 7. getAllDepartmentsOfOrganization(long orgId);");
		System.out.println("******************************************\n");
	}

	private static void showDepartmentMenu() {
		System.out.println("******************************************");
		System.out.println(" 1. addDepartment(Department department);\n"
				+ " 2. updateDepartment(long id);\n"
				+ " 3. deleteDepartment(long id);\n"
				+ " 4. findById(long id);\n"
				+ " 5. getDepartments();\n"
				+ " 6. getAllEmployeesOfDepartment(long deptId);\n"
				+ " 7. getAllDepartmentsOfOrganization(long orgId);");
		System.out.println("*****************************************\n");

	}
	
	private static void showEmployeeMenu() {
		System.out.println("******************************************");
		System.out.println(" 1. addEmployee(Employee employee);\n"
				+ " 2. updateEmployee(long id);\n"
				+ " 3. deleteEmployee(long id);\n"
				+ " 4. findById(long id);\n"
				+ " 5. getEmployees();\n"
				+ " 6. findByOrganizationId(long id);");
		System.out.println("******************************************");
	}



}
