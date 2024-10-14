package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class dupdate {

	public static void main(String[] args) throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
	    String s = "update Doctors set name=? where doctor_id=?";
	    PreparedStatement pstmt = con.prepareStatement(s);
	    Scanner scan= new Scanner(System.in);
	    System.out.println("Enter the doctor name");
	    String name= scan.next();
	    System.out.println("Enter the doctor_id");
	    int doctor_id = scan.nextInt();
	

	    pstmt.setString(1, name);
	    pstmt.setInt(2, doctor_id);
	
	
	    int rows = pstmt.executeUpdate();
	    System.out.println(rows);
		// TODO Auto-generated method stub

	}

}
