package com.loyal.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleJDBCConnection {

	public static void main(String args[]) {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","loyal",
					"loyal123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}
