package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
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

	public void insert(String db, String tableName) {
		System.out.println("Enter movie_name,actor,actress,director,year_of_release");
		Scanner scanner = new Scanner(System.in);
		String movie_name = scanner.nextLine();
		String actor = scanner.nextLine();
		String actress = scanner.nextLine();
		String director = scanner.nextLine();
		int year = scanner.nextInt();
		scanner.nextLine();
		String sql = "INSERT INTO " + tableName + "(name,actor,actress,director,year_of_release) VALUES(?,?,?,?,?)";

		try {
			Connection conn = this.connect(db);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_name);
			pstmt.setString(2, actor);
			pstmt.setString(3, actress);
			pstmt.setString(4, director);
			pstmt.setLong(5, year);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
