package com.vas2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "root";
		String pass = "admin";

		try {

			System.out.println("connecting to database" + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			
			if(!myConn.isClosed()) {
				System.out.println("Connection Succesful!!!" );
			}else
			{
				System.out.println("Connection is closed");
			}

			

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
	}

}
