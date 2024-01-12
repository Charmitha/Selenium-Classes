package p1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQL {
	public static Connection connection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/jfsd";
		String user = "root";
		String password = "Charmitha@5";
		try {
			con = DriverManager.getConnection(url, user,password);
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
