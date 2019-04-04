package keeptrack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class KeepTrack3Calculations
{

	  public double amount1(double totalworkingdays1, double rate1,String leaves) throws ClassNotFoundException
	  {
		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		  String DB_URL = "jdbc:mysql://localhost:3306/db";
		  String USER = "root";
		  String PASS = "root";
	      Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  double amount = 0;

	   try
		 {
			     
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT totalworkingdays,Rate,Leaves FROM KeepTracks3";
		      //rs = stmt.executeQuery(sql);
		      stmt.executeUpdate(sql);
//		      while(rs.next())
//		      {
		  
		    	 double totalworkingdays = getInt("totalworkingdays");
		    	 System.out.println(totalworkingdays);
		    	 double leave = rs.getInt("Leaves");
		    	 System.out.println(leave);
		    	 double rate = rs.getInt("Rate");
		    	 System.out.println(rate);
		    	 amount=((totalworkingdays-leave)*rate);
		    	 System.out.println(amount);
		    	 System.out.println("----------");
		    	 //return amount;
		        
		   //  }
		 }
		  catch(SQLException e) 
		  {
			 System.out.println("Exception Ocurred15"); 
		  }
	   	return amount;
	  
	     }
}
	  
	
//package keeptrack3;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.DecimalFormat;
//
//public class KeepTrack3Calculations
//{
//	 public double totalworkindays1() throws ClassNotFoundException
//	  {
//		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//		  String DB_URL = "jdbc:mysql://localhost:3306/db";
//		  String USER = "root";
//		  String PASS = "root";
//	      Connection conn = null;
//		  Statement stmt = null;
//		  ResultSet rs = null;
//		  double totalworkingdays=0;
//
//	   try
//		 {
//			     
//		      Class.forName("com.mysql.jdbc.Driver");
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//		      stmt = conn.createStatement();
//		      String sql;
//		      sql = "SELECT totalworkingdays,Rate,Leave FROM KeepTracks3";
//		      rs = stmt.executeQuery(sql);
//		      double totalworkingdays1 = rs.getInt("totalworkingdays");
//		      totalworkingdays=totalworkingdays1+totalworkingdays;
//		        
//		      }
//		 
//		  catch(SQLException e) 
//		  {
//			 System.out.println("Exception Ocurred15"); 
//		  }
//		    return totalworkingdays;
//	  
//	     }
//	  
//public double leaves1() throws ClassNotFoundException
//	  {
//		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//		  String DB_URL = "jdbc:mysql://localhost:3306/db";
//		  String USER = "root";
//		  String PASS = "root";
//	      Connection conn = null;
//		  Statement stmt = null;
//		  ResultSet rs = null;
//		  double leaves=0;
//
//	   try
//		 {
//			     
//		      Class.forName("com.mysql.jdbc.Driver");
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//		      stmt = conn.createStatement();
//		      String sql;
//		      sql = "SELECT totalworkingdays,Rate,Leaves FROM KeepTracks3";
//		      rs = stmt.executeQuery(sql);
//		      while(rs.next())
//		      {
//		  
//		    	
//		    	 double leave = rs.getInt("Leaves");
//		    	 leaves=leave+leave;
//		        
//		      }
//		 }
//		  catch(SQLException e) 
//		  {
//			 System.out.println("Exception Ocurred15"); 
//		  }
//		    return leaves;
//	  
//	     }
//	  public double rate1() throws ClassNotFoundException
//	  {
//		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//		  String DB_URL = "jdbc:mysql://localhost:3306/db";
//		  String USER = "root";
//		  String PASS = "root";
//	      Connection conn = null;
//		  Statement stmt = null;
//		  ResultSet rs = null;
//		  double rate=0;
//
//	   try
//		 {
//			     
//		      Class.forName("com.mysql.jdbc.Driver");
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//		      stmt = conn.createStatement();
//		      String sql;
//		      sql = "SELECT totalworkingdays,Rate,Leave FROM KeepTracks3";
//		      rs = stmt.executeQuery(sql);
//		      while(rs.next())
//		      {
//		  
//		    	 double rate1 = rs.getInt("Rate");
//		    	 rate=rate1+rate;
//		        
//		      }
//		 }
//		  catch(SQLException e) 
//		  {
//			 System.out.println("Exception Ocurred15"); 
//		  }
//		    return rate;
//	  
//	     }
//	  public double amount(double totalworkingdays,double rate,double leaves) throws ClassNotFoundException 
//	  {
//		
//		  double amount=0;
//		  amount=(totalworkingdays-leaves)*rate;
//		   return amount;
//	  }
//	  
//	}
	  