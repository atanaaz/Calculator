package com.sidgs.calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
	
	public Connection getConnection() {
		String driverClassName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/sidgs";
		String user="root";
		String password="Welcome5!";
		Connection con=null;
		
		try {
			Class.forName(driverClassName);
			con= DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
		
		
	}
}
