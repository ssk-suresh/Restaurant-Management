package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private static Connection con=null;
	public DBConnection() 
	{
		// TODO Auto-generated constructor stub
		}
	public static Connection getConnection() 
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	}
	catch(ClassNotFoundException clse)
	{
		clse.printStackTrace();
	}
	catch (SQLException sqle) 
	{
    	// TODO Auto-generated catch block
		sqle.printStackTrace();
	}
	
	return con;
	}
}

