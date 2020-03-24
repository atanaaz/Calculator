package com.sidgs.calculator;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CalculatorDb {
	
	public void setResult(String result, String uname) throws SQLException {
	
		
		DbUtility db=new DbUtility();
		Connection con= db.getConnection();
		String sql="Insert into results values(?,?,?)";
		PreparedStatement ps;
		
		Date date=new Date();
		Timestamp ts=new Timestamp(date.getTime());
		
	try {

	ps=con.prepareStatement(sql);
	ps.setString(1, uname);
	ps.setString(2, result);
	ps.setTimestamp(3, ts);
	ps.executeUpdate();
	
	}catch( SQLException sqe) {
		sqe.getStackTrace();
	}
	con.close();
	}
	
	public List<String> getResult(String uname, int p) {
		DbUtility db=new DbUtility();
		Connection con= db.getConnection();
		String sql="Select result from results where name=? order by time desc Limit ?";
		List<String> l=new ArrayList<String>();
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setInt(2, p);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {			
			 l.add(rs.getString("result"));
			
			}
			
		
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return l;
		
		
	}
	
	public String getPreference(String name) {
		DbUtility db=new DbUtility();
		Connection con= db.getConnection();
		String sql="Select upref from user where name=?";
		String pref=null;
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {			
			  pref=rs.getString("upref");
			
			}
			
		
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pref;
		
		
	}
	
	
}
