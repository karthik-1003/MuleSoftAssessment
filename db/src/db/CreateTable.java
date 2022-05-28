package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public void createNewTable(String db, String tableName) {
		String url = "jdbc:sqlite:C://sqlite/" + db;

		String sql = "CREATE TABLE IF NOT EXISTS " + tableName + "(\n" + "id integer PRIMARY KEY AUTOINCREMENT,\n"
				+ "name text NOT NULL,\n" + "actor text NOT NULL,\n" + "actress text NOT NULL,\n"
				+ "director text NOT NULL,\n" + "year_of_release integer NOT NULL\n" + ");";

		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Table Created");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
