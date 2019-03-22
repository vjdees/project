package keeptrack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class KeepTrack2Calculations
{


	

	 public double pdtosp2(double workingdays,double agreedsp)
	  {
		  DecimalFormat df = new DecimalFormat(".##");
		  double pdtosp = workingdays/agreedsp;
		  return Double.parseDouble(df.format(pdtosp));
	  }
	  public int actualsp(double agreed_sp,double leaves,double pd_to_sp)
	  {
		  int actual_sp = (int)(Math.round((agreed_sp - (leaves/pd_to_sp))));
		  //System.out.println(actual_sp);
		  return actual_sp;
		 
	  }
	  
	  public double allocatedSpOnsite() throws ClassNotFoundException
	  {
		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		  String DB_URL = "jdbc:mysql://localhost:3306/db";
		  String USER = "root";
		  String PASS = "root";
	      Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  double ans=0;
		  String location="";
	   try
		 {
			     
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT Location,agreedsp FROM KeepTracks2";
		      rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	 location = rs.getString("Location");
		    	 double allocatedsp = rs.getFloat("agreedsp");
		    	 if(location.equals("Onsite"))
		    		 ans = ans + allocatedsp;
		      }
		 }
		  catch(SQLException e)
		  {
			 System.out.println("Exception Ocurred15"); 
		  }
		    return ans;
	  
	     }
	  public double allocatedSpOffshore() throws ClassNotFoundException
	  {
		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		  String DB_URL = "jdbc:mysql://localhost:3306/db";
		  String USER = "root";
		  String PASS = "root";
	      Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  double ans=0;
		  String location="";
	   try
		 {
			     
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT Location,agreedsp FROM KeepTracks2";
		      rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	 location = rs.getString("Location");
		    	 double allocatedsp = rs.getFloat("agreedsp");
		    	 if(location.equals("Offshore"))
		    		 ans = ans + allocatedsp;
		      }
		 }
		  catch(SQLException e)
		  {
			 System.out.println("Exception Ocurred45"); 
		  }
		    return ans;
	  
	     }
	  public double actualSpOffshore() throws ClassNotFoundException
	  {
		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		  String DB_URL = "jdbc:mysql://localhost:3306/db";
		  String USER = "root";
		  String PASS = "root";
	      Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  double ans=0;
		  String location="";
	   try
		 {
			     
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT Location,actualsp FROM KeepTracks2";
		      rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	 location = rs.getString("Location");
		    	 double allocatedsp = rs.getFloat("actualsp");
		    	 if(location.equals("Offshore"))
		    		 ans = ans + allocatedsp;
		      }
		 }
		  catch(SQLException e)
		  {
			 System.out.println("Exception Ocurred76"); 
		  }
		    return ans;
	  
	     }
	  public double actualSpOnsite() throws ClassNotFoundException
	  {
		  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		  String DB_URL = "jdbc:mysql://localhost:3306/db";
		  String USER = "root";
		  String PASS = "root";
	      Connection conn = null;
		  Statement stmt = null;
		  ResultSet rs = null;
		  double ans=0;
		  String location="";
	   try
		 {
			     
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT Location,actualsp FROM KeepTracks2";
		      rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	 location = rs.getString("Location");
		    	 double allocatedsp = rs.getFloat("actualsp");
		    	 if(location.equals("Onsite"))
		    		 ans = ans + allocatedsp;
		    	 	//System.out.println(ans);
		      }
		 }
		  catch(SQLException e)
		  {
			 System.out.println("Exception Ocurred27"); 
		  }
		    return ans;
	  
	     }
	  public int slabRateOnsite() throws ClassNotFoundException
	  {
		 double total_allocated_sp_onsite = allocatedSpOnsite();
		 int slabrate_onsite = 0;
		  if(total_allocated_sp_onsite >=0 && total_allocated_sp_onsite<=200)
		    {
		    	 slabrate_onsite=290;
		    }
		     else if(total_allocated_sp_onsite >=201 && total_allocated_sp_onsite<=400)
			    {
			    	 slabrate_onsite=275;
			    }
		     else if(total_allocated_sp_onsite >=401 && total_allocated_sp_onsite<=600)
			    {
			    	 slabrate_onsite=255;
			    }
		     else if(total_allocated_sp_onsite >=601 && total_allocated_sp_onsite<=800)
			    {
			    	 slabrate_onsite=250;
			    }
		     else if(total_allocated_sp_onsite >=801 && total_allocated_sp_onsite<=1000)
			    {
			    	 slabrate_onsite=245;
			    }
		     else if(total_allocated_sp_onsite >=1001 && total_allocated_sp_onsite<=1500)
			    {
			    	 slabrate_onsite=240;
			    }
		     else if(total_allocated_sp_onsite >=1501 && total_allocated_sp_onsite<=2000)
			    {
			    	 slabrate_onsite=238;
			    }
		     else if(total_allocated_sp_onsite >=2001 && total_allocated_sp_onsite<=9999)
			    {
			    	 slabrate_onsite=235;
			    }
			 
		  
		  return slabrate_onsite;
		 
	  }
	  public int slabRateOffshore() throws ClassNotFoundException
	  {
		  double total_allocated_sp_offshore = allocatedSpOffshore();
			 int slabrate_offshore = 0;
		  
		  if(total_allocated_sp_offshore >=0 && total_allocated_sp_offshore<=100)
		    {
		    	 slabrate_offshore=100;
		    }
		     else if(total_allocated_sp_offshore >=20 && total_allocated_sp_offshore<=400)
			    {
			    	 slabrate_offshore=98;
			    }
		     else if(total_allocated_sp_offshore >=401 && total_allocated_sp_offshore<=600)
			    {
			    	 slabrate_offshore=96;
			    }
		     else if(total_allocated_sp_offshore >=601 && total_allocated_sp_offshore<=800)
			    {
			    	 slabrate_offshore=94;
			    }
		     else if(total_allocated_sp_offshore >=801 && total_allocated_sp_offshore<=1000)
			    {
			    	 slabrate_offshore=92;
			    }
		     else if(total_allocated_sp_offshore >=1001 && total_allocated_sp_offshore<=1500)
			    {
			    	 slabrate_offshore=91;
			    }
		     else if(total_allocated_sp_offshore >=1501 && total_allocated_sp_offshore<=2000)
			    {
			    	 slabrate_offshore=90;
			    }
		     else if(total_allocated_sp_offshore >=2001 && total_allocated_sp_offshore<=9999)
			    {
			    	 slabrate_offshore=89;
			    }
			return slabrate_offshore;
			 
	  }
	  public double revenue(String location,double actualsp) throws ClassNotFoundException 
	  {
		
		  double ans=0;
		  if(location.equals("'Onsite',"))
		  {
		     ans = actualsp * slabRateOnsite();
		  }
		  else
		  {
			 ans = actualsp * slabRateOffshore();
		  }
		   return ans;
	  }
	  
	}



