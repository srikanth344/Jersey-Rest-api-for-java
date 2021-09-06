package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.restapi.crud.crud.model.crudmodel;

public class crudservice {
	
	Connection con;
	
	public crudservice()  {
		try {
			String url = String.format("jdbc:mysql://localhost:3306/user");
			String uname = "root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
			
		}
		
	}
	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into student(STUDENT_NO,STUDENT_NAME,STUDENT_DOB,STUDENT_DOJ) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, user.getSTUDENT_NO());
			ps.setString(2, user.getSTUDENT_NAME());
			ps.setDate(3, user.getSTUDENT_DOB());
			ps.setDate(4, user.getSTUDENT_DOJ());
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
			
		}
	
		return user;
		
	}
	
    public ArrayList<crudmodel> getUser() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from student";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setSTUDENT_NO(rs.getInt("STUDENT_NO")); // column name
			model.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
			model.setSTUDENT_DOB(rs.getDate("STUDENT_DOB"));
			model.setSTUDENT_DOJ(rs.getDate("STUDENT_DOJ"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<crudmodel> getUserById(int STUDENT_NO) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from student where STUDENT_NO =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,STUDENT_NO);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			model.setSTUDENT_NO(rs.getInt("STUDENT_NO"));
			model.setSTUDENT_NAME(rs.getString("STUDENT_NAME")); // column name
			model.setSTUDENT_DOB(rs.getDate("STUDENT_DOB"));
			model.setSTUDENT_DOJ(rs.getDate("STUDENT_DOJ"));
			data.add(model);		
		}		
		return data;	
	}
	
	public crudmodel updatetUser(crudmodel user) {
		String insert = "update student set STUDENT_NAME=? , STUDENT_DOB=?, STUDENT_DOJ=? where STUDENT_NO =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getSTUDENT_NAME());			
			ps.setDate(2, user.getSTUDENT_DOB());
			ps.setDate(3, user.getSTUDENT_DOJ());
			ps.setInt(3, user.getSTUDENT_NO());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	

	public int deletetUser(int STUDENT_NO) {
		String insert = "delete from person where STUDENT_NO =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,STUDENT_NO);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return STUDENT_NO;
		
	}
	
	


	
	
	
}


