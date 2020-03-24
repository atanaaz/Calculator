package com.sidgs.calculator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDb {

	public User validateUser(String name, String pass) {
		
		DbUtility db=new DbUtility();
		Connection con= db.getConnection();
		String sql="Select * from User where name=? and password=?";
		PreparedStatement smt;
	
		User u=null;
		
		try {
		
		smt=con.prepareStatement(sql);
		smt.setString(1, name);
		smt.setString(2, pass);
		
		ResultSet rs=smt.executeQuery();
		
		while(rs.next()) {
			u=new User();
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
		}
		
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public void setPreference(int i, String uname) {
		
		DbUtility db=new DbUtility();
		Connection con= db.getConnection();
		String sql="Update User set upref=? where name=? ";
		PreparedStatement smt;
		
		try {
			smt= con.prepareStatement(sql);
			smt.setString(2, uname);
			smt.setInt(1, i);
			smt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
