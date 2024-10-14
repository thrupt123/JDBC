package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class pdelete {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
		String s = "delete from Patients where patient_id=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the Patient ID");
		int patient_id = sc.nextInt();
		pstmt.setInt(1, patient_id);
		int rows = pstmt.executeUpdate();
        System.out.println(rows);
	}

}
