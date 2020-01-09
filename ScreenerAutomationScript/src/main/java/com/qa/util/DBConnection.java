package com.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBConnection {

	@Test
	public static void  DBConnection() throws SQLException, ClassNotFoundException 
	{
		// TODO Auto-generated method stub
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.6.1.102:1433", "clear", "clear");
			
			Statement stmt = conn.createStatement();
			ResultSet MFAQuery = stmt.executeQuery("select top 1 * from clear.[MFATokens]\n" + 
					"where Context='LOGIN'\n" + 
					"order by 1 desc");
			
			while (MFAQuery .next()) {
				String Token = MFAQuery .getString(3);
				 System.out.println(Token);
				 }
			
			if (MFAQuery != null)
			{
				 try 
				 {
					 MFAQuery.close();
				 } 
				 catch (Exception e)
				 {
					 
				 }
			}
				 
				 
				 if (stmt != null) 
				 {
					 try 
				 {
					 stmt.close();
				 } 
					 catch (Exception e) 
					 {
						 
					 }
				 }
				 
				 
				 if (conn != null) 
				 {
					 try 
				 {
						 conn.close();
				 }
					 catch (Exception e)
					 { }
				 }
				 
				//return (String) null;
				 
			

	}

}
