package db;

import java.util.Scanner;

public class Sqlitedb {
	public static void main(String[] args) {
		String db, tableName;
		int ch;
		Scanner scanner = new Scanner(System.in);
		Check check = new Check();
		boolean ans;
		while (true) {
			System.out.println("\n1:Create a DataBase");
			System.out.println("2:Create a Table in DataBase");
			System.out.println("3:Insert into Table");
			System.out.println("4:Select from Table");
			System.out.print("Enter choice: ");
			ch = scanner.nextInt();
			scanner.nextLine();
			switch (ch) {
			case 1:
				System.out.print("Enter the name of the Database: ");
				db = scanner.nextLine();
				db = db + ".db";
				check = new Check();
				ans = check.checkDB(db);
				if (ans == true) {
					System.out.println("Database Exists");
				} else {
					Create newdb = new Create();
					newdb.createNewDb(db);
				}

				break;
			case 2:
				System.out.print("Enter the name of the Database: ");
				db = scanner.nextLine();
				db = db + ".db";
				check = new Check();
				ans = check.checkDB(db);
				if (ans == false) {
					System.out.println("NO SUCH DATABASE");
					break;
				}
				System.out.print("Enter a table name to store movie details: ");
				tableName = scanner.nextLine();
				CreateTable table = new CreateTable();
				table.createNewTable(db, tableName);
				break;
			case 3:
				System.out.print("Enter the name of the Database: ");
				db = scanner.nextLine();
				db = db + ".db";

				ans = check.checkDB(db);
				if (ans == false) {
					System.out.println("NO SUCH DATABASE");
					break;
				}
				System.out.print("Enter the table name: ");
				tableName = scanner.nextLine();
				Insert input = new Insert();
				input.insert(db, tableName);
				break;
			case 4:
				System.out.print("Enter the name of the Database: ");
				db = scanner.nextLine();
				db = db + ".db";
				ans = check.checkDB(db);
				if (ans == false) {
					System.out.println("NO SUCH DATABASE");
					break;
				}
				System.out.print("Enter the table name: ");
				tableName = scanner.nextLine();
				Select select = new Select();
				System.out.print("1:Select All movies \n2:Select movies based on actor \nEnter choice: ");
				int op = scanner.nextInt();
				select.selectAll(db, tableName, op);
				break;
			default:
				return;
			}
		}

	}
}
