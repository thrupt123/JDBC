package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class pread {
	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
		
		String s ="select * from Patients where patient_id=?";
		
		PreparedStatement pstmt =con.prepareStatement(s);
		
		System.out.println("Enter the Patient_id");
		Scanner scan = new Scanner(System.in);
		int patient_id = scan.nextInt();
		pstmt.setInt(1,patient_id);
		ResultSet res = pstmt.executeQuery();
		if(res.next()) {
			patient_id = res.getInt(1);
			String name = res.getString(2);
			int age=res.getInt(3);
			int contact_number=res.getInt(4);
			System.out.println(patient_id+" "+name+" "+age+" "+contact_number);
		}
		else {
			System.out.println("Invalid id");
		}

    }
}
