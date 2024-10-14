package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class registration {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.println("1.New user");
		System.out.println("2.Login");
		System.out.println("Enter your choice");
		int choice=scan.nextInt();
		
		switch(choice) {
		case 1:register();
		break;
			
		case 2:login();
		break;
		
		default: System.out.println("Invalid choice");
		break;
		}
	}



	static void register() throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Thrupthi@2002");
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter name:");
		String name=scan.next();
		System.out.println("Enter username:");
		String username=scan.next();
		while(true) {
			String s="select * from user where username=?";
		    PreparedStatement pstmt=con.prepareStatement(s);
		    pstmt.setString(1, username);
		    ResultSet res=pstmt.executeQuery();
		    if(res.next()) {
		    	System.out.println("username already exists.Please enter another username");
			    username=scan.next();
		    }
		    else {
		    	break;
		    }
		}
		
		String password;
		String confirmpassword;
	    do {
	    	System.out.println("Enter password:");
	        password=scan.next();
		    System.out.println("Confirm password:");
		    confirmpassword=scan.next();
	    }while(!password.equals(confirmpassword));

		
		System.out.println("Enter email:");
		String email=scan.next();
			
		String s1 ="insert into user values(?,?,?,?)";
		PreparedStatement pstmt1=con.prepareStatement(s1);
		pstmt1.setString(1, name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		pstmt1.executeUpdate();
		
		
		
	}
	
	
	
	
	
	
    static void login() throws Exception {
    	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Thrupthi@2002");
    	Scanner scan= new Scanner(System.in);
    	System.out.println("Enter username:");
    	String username= scan.next();
    	System.out.println("Enter password:");
    	String password=scan.next();
    	
    
		String s="select * from user where username=? ";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1, username);
		ResultSet res=pstmt.executeQuery();
		if(res.next()) {
			if(password.equals(res.getString(3))){
				System.out.println("Login Successful");
		    }
		    else {
		    	System.out.println("Invalid password");
		    }
		}
		else {
		    System.out.println("Invalid username");
		}
		
    	
    	

    	
		
	  }
	}



