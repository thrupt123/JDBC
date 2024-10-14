package hospital_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class dcreate {
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());                                                       
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managment","root","Thrupthi@2002");
		                                                                                                                    
		String s =" insert into Doctors values(?,?,?)";                                                                  
		                                                                                                                    
		PreparedStatement pstmt =con.prepareStatement(s);                                                                   
		System.out.println("Enter the doctor_id");                                                                         
		Scanner scan = new Scanner(System.in);                                                                              
		int doctor_id = scan.nextInt();                                                                                    
		System.out.println("Enter the name");                                                                               
		String name = scan.next();                                                                                          
		System.out.println("Enter the specialization");                                                                                
		String specialization = scan.next();                                                                                           
                                                                               
		                                                                                                                    
		pstmt.setInt(1,doctor_id);                                                                                         
		pstmt.setString(2,name);                                                                                            
		pstmt.setString(3,specialization);                                                                                                
                                                                                   
		                                                                                                                    
		int rows = pstmt.executeUpdate();                                                                                   
		System.out.println(rows);                                                                                           
		                                                                                                                    
		// TODO Auto-generated method stub                                                                                  
                                                                                                                            
	}       

}
