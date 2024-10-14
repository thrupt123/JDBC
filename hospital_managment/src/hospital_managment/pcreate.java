package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class pcreate {

	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
		
		String s =" insert into Patients values(?,?,?,?)";
		
		PreparedStatement pstmt =con.prepareStatement(s);
		System.out.println("Enter the Patient_id");
		Scanner scan = new Scanner(System.in);
		int patient_id = scan.nextInt();
		System.out.println("Enter the name");
		String name = scan.next();
		System.out.println("Enter the age");
		int age = scan.nextInt();
		System.out.println("Enter the contact_number");
		int contact_number = scan.nextInt();
		
		pstmt.setInt(1,patient_id);
		pstmt.setString(2,name);
		pstmt.setInt(3,age);
		pstmt.setInt(4,contact_number);
		
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
		
		// TODO Auto-generated method stub

	}

}
