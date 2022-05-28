package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create {
	public void createNewDb(String fileName) {
		String url = "jdbc:sqlite:C:\\sqlite\\" + fileName;
		try {

			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Driver name: " + meta.getDriverName());
				System.out.println("Database Created");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
