package com.spring.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String username = "root";
        String password = "tonmoysahaopi";
        String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";
        
        try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection successfully");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
