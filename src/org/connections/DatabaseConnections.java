package org.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnections {
	
	
	public static void main(String[] args) {
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
			 
			 String sql = "select * from employees";
			 
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
				 
				 String firstname = rs.getString("First_name");
				 String lastname = rs.getString("Last_name");
				 
				 
				 System.out.println(firstname);
				 System.out.println(lastname);
			}
			 con.close();
			 
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}