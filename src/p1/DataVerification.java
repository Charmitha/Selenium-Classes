package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataVerification {
	static Connection con = ConnectionSQL.connection();

	public static String verify(int id, String name, String email, String dob) {
		String ack = "";
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENTS WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String n = rs.getString(2);
				String e = rs.getString(3);
				String d = rs.getString(4);
				if(n.equalsIgnoreCase(name)) {
					ack +="Name-MATCHED,   ";
				}
				else {
					ack +="Name-MIS-MATCHED,   ";
				}
				if(e.equalsIgnoreCase(email)) {
					ack +="EMAIL-MATCHED,   ";
				}
				else {
					ack +="EMAIL-MIS-MATCHED,   ";
				}
				if(d.equalsIgnoreCase(dob)) {
					ack +="DOB-MATCHED,   ";
				}
				else {
					ack +="DOB-MIS-MATCHED,   ";
				}
			}
			else {
				ack += "ID NOT FOUND...";
			}
			return ack;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
