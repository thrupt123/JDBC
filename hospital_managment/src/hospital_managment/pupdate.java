package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class pupdate {
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
	    String s = "update Patients set contact_number=? where patient_id=?";
	    PreparedStatement pstmt = con.prepareStatement(s);
	    Scanner scan= new Scanner(System.in);
	    System.out.println("Enter the Patient contact_number");
	    int contact_number= scan.nextInt();
	    System.out.println("Enter the patient_id");
	    int patient_id = scan.nextInt();
	

	    pstmt.setInt(1, contact_number);
	    pstmt.setInt(2, patient_id);
	
	
	    int rows = pstmt.executeUpdate();
	    System.out.println(rows);
	}

}
