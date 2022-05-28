package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {
	private Connection connect(String db) {
		String url = "jdbc:sqlite:C://sqlite/" + db;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void selectAll(String db, String tableName, int option) {
		if (option == 1) {
			String sql = "SELECT * FROM " + tableName;
			try {
				Connection conn = this.connect(db);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("ID \t Movie \t Actor \t Actress \t Director \t Years");
				while (rs.next()) {
					System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("actor")
							+ "\t" + rs.getString("actress") + "\t" + rs.getString("director") + "\t"
							+ rs.getInt("year_of_release"));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else if (option == 2) {
			System.out.print("Enter Actor Name: ");
			Scanner scanner = new Scanner(System.in);
			String aname = scanner.nextLine();
			String sql = "SELECT name FROM " + tableName + " WHERE actor = " + '"' + aname + '"';
			try {
				Connection conn = this.connect(db);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {

					System.out.println(rs.getString("name"));

				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} else {
			return;
		}
	}
}
