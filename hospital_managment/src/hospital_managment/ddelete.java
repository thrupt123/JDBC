package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ddelete {
	public static void main(String[] args) throws SQLException{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());                                                         
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
		String s = "delete from Doctors where doctor_id=?";                                                                 
		PreparedStatement pstmt = con.prepareStatement(s);                                                                    
		Scanner scan = new Scanner(System.in);                                                                                  
		System.out.println("Enter the doctor ID");                                                                           
		int doctor_id = scan.nextInt();                                                                                        
		pstmt.setInt(1, doctor_id);                                                                                          
		int rows = pstmt.executeUpdate();                                                                                     
        System.out.println(rows);   
		// TODO Auto-generated method stub

	}

}
