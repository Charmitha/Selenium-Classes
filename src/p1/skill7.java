package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class skill7 {

	static Connection con = ConnectionSQL.connection();

	public static String insert() {
		String ack ="";
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Provide id: ");
			int id = sc.nextInt();
			PreparedStatement ps = null;
			ps = con.prepareStatement("SELECT * FROM STUDENTS WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("ID MATCHED,PROVIDE DETAIILS");
				System.out.println("Provide name: ");
			String name = sc.next();
			System.out.println("Provide email: ");
			String email = sc.next();
			System.out.println("Provide dob(dd/mm/yyyy): ");
			String dob = sc.next();
			 ps = con.prepareStatement("UPDATE STUDENTS SET name=?, email=?,dob=? WHERE ID=? ");
			 ps.setString(1, name);
			 ps.setString(2,email);
			 ps.setString(3, dob);
			 ps.setInt(4, id);
			 
			 ps.execute();
			 ack = "INSERTED\n";
			}
			else {
				ack += "ID MISMATCH";
			}
			return ack;	 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
