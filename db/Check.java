package db;

import java.io.File;

public class Check {
	public boolean checkDB(String fileName) {
		File file = new File("C:\\sqlite\\" + fileName);
		if (file.exists()) {
			return true;
		}
		return false;
	}
}
