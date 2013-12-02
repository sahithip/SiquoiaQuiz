package com.siquoia.dbconnection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class DBConnection {


	public Connection getConnection()
	{
		Connection con = null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/siquoia", "root", "dille123");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public void closeConnection(Connection con)
	{
		if(con != null)
		{
			try 
			{
				con.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closeStatement(PreparedStatement stmnt)
	{
		if(stmnt != null)
		{
			try 
			{
				stmnt.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public static void main(String args[]) throws SQLException{
//		Connection con = new DBConnection().getConnection();
//		System.out.println("con---"+con);
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM user");
//		while (rs.next()) {
//			String id = rs.getString("user_id");
//			String firstName = rs.getString("user_name");
//			String lastName = rs.getString("password");
//			System.out.println("ID: " + id + ", First Name: " + firstName
//					+ ", Last Name: " + lastName);
//	}
//}
}
