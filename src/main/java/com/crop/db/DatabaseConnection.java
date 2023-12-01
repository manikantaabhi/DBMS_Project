package com.crop.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection getConnection()
	{
		Connection con=null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop decision management system","root","");
		
		}catch(Exception e)
		{
			System.out.println(e);
	
		}
		return con;
	}
}
