package com.tcs.employeeapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_management?useSSL=false", 
							"root", "MYSQL123$");
			
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
