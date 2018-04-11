package de.hwrberlin.friendsforfun.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenceManager {

	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName : " + e.getMessage());
		}
		String url = "jdbc:mariadb://localhost:3306/test2";
		Connection con = DriverManager.getConnection(url, "root", "root");

	}

}
