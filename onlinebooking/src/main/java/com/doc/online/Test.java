package com.doc.online;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;

public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
//		test.connectdb();
		System.out.println(LocalTime.now());
	}

	public void connectdb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedoc","root","root");
			System.out.println(connection.isValid(0));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
