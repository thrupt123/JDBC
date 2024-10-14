package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class dread {

	public static void main(String[] args) throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
		
		String s ="select * from Doctors where doctor_id=?";
		
		PreparedStatement pstmt =con.prepareStatement(s);
		
		System.out.println("Enter the doctor_id");
		Scanner scan = new Scanner(System.in);
		int doctor_id = scan.nextInt();
		pstmt.setInt(1,doctor_id);
		ResultSet res = pstmt.executeQuery();
		if(res.next()) {
			doctor_id = res.getInt(1);
			String name = res.getString(2);
			String specialization=res.getString(3);
			System.out.println(doctor_id+" "+name+" "+specialization);
		}
		else {
			System.out.println("Invalid id");
		// TODO Auto-generated method stub

	    }
	}

}
