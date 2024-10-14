package com.qn.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
   private int id;
   private String name;
   private int marks1;
   private int marks2;
   private int marks3;
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Student() {
	super();
}
public Student(int id, String name, int marks1, int marks2, int marks3) {
	super();
	this.id = id;
	this.name = name;
	this.marks1 = marks1;
	this.marks2 = marks2;
	this.marks3 = marks3;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks1() {
	return marks1;
}
public void setMarks1(int marks1) {
	this.marks1 = marks1;
}
public int getMarks2() {
	return marks2;
}
public void setMarks2(int marks2) {
	this.marks2 = marks2;
}
public int getMarks3() {
	return marks3;
}
public void setMarks3(int marks3) {
	this.marks3 = marks3;
}

public int addResult() {
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "Thrupthi@2002");
		
		String s ="insert into student values(?,?,?,?,?)";
		PreparedStatement p =c.prepareStatement(s);
		p.setInt(1, id);
		p.setString(2, name);
		p.setInt(3, marks1);
		p.setInt(4, marks2);
		p.setInt(5, marks3);
		int r = p.executeUpdate();
		return r;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}

	@Override
	public String toString() {
		return "Student [id=" +id+",name=" + name+",marks1="+marks1+",marks2="+marks2+",marks3="+marks3+"]";
	}
}