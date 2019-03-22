package keeptrack3;



import keeptrack2.MyBean;
import keeptrack3.KeepTrack3Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KeepTrack3Jdbc {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false";
	   static final String USER = "root";
	   static final String PASS = "root";
	   public void insertToDataBase(KeepTrack3Bean keeptrack3Bean)
		{
			   Connection conn = null;
			   Statement stmt = null;
			   ResultSet rs = null;
			   try
			   {
			      Class.forName("com.mysql.jdbc.Driver");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      Statement statement = conn.createStatement();
			      String gfd="";
			      String resource_name = "'" + keeptrack3Bean.getresource_name() +"',";
			      String sow ="'"+ keeptrack3Bean.getsow() +"'";
			      String comments =  "'"+ keeptrack3Bean.getcomments() +"'";
			      String start_date = "'" + keeptrack3Bean.getstart_date() +"',";
			      String end_date = "'" +keeptrack3Bean.getend_date()+"',";
			      double rate_set = Double.parseDouble(keeptrack3Bean.getrate_set());
			      int sap_id = (int)Double.parseDouble(keeptrack3Bean.getsap_id());
			      int employee_id = (int)Double.parseDouble(keeptrack3Bean.getemployee_id());
			      String rate = "'" + keeptrack3Bean.getrate()+"',";
			      String location = "'" + keeptrack3Bean.getlocation()+"',";
			      String desig = "'" + keeptrack3Bean.getdesig()+"',";
			      String cat = "'" + keeptrack3Bean.getcat()+"',";
			      //String amount = "'" + keeptrack3Bean.getamount()+"',";
			      double workingdays = Double.parseDouble(keeptrack3Bean.getworkingdays());
			      String leaves = "'" + keeptrack3Bean.getleaves()+"',";
			      String leave_dates = "'" + keeptrack3Bean.getleave_dates()+"',";
			      String w1 = "'" + keeptrack3Bean.getw1()+"',";
			      String w2 = "'" + keeptrack3Bean.getw2()+"'";
			      String w3 = "'" + keeptrack3Bean.getw3()+"',";
			      String w4 = "'"+keeptrack3Bean.getw4()+"'";
			      String w5 =  "'"+keeptrack3Bean.getw5()+"'";
			      String flag = "'"+keeptrack3Bean.getflag()+"'";
			     // KeepTrack2Calculations obj = new KeepTrack2Calculations();
			      try
			      {
			  
			    	  gfd ="INSERT INTO KeepTracks3(Resource_Name,SOW,Comments,Start_Date,End_Date,Rate_Set,SAP_ID,ID,Location,Desig,Cat,Working_Days,Leaves,Leave_Dates,w1,w2,w3,w4,w5,Flag) VALUES" +"("+ resource_name +  sow + comments + start_date + end_date +","+ rate_set+","+sap_id+employee_id+ location + desig +","+ workingdays +","+ leaves + leave_dates + w1 + w2 + w3 + w4 + w5 + flag +")";
			    	  statement.executeUpdate(gfd);
			    	  System.out.println(gfd);
			      }
			      catch(SQLException q)
			      {	  //System.out.println("Error");	
			    	/*  double pdtosp=obj.pdtosp2(workingdays,agreedsp);
			    	  double actualsp =obj.actualsp(agreedsp,Double.parseDouble(myBean.getleaves()),pdtosp);
			    	  double allocatedsp_onsite = obj.allocatedSpOnsite();
			    	  double allocatedsp_offshore = obj.allocatedSpOffshore();
			    	  double actualsp_onsite = obj.actualSpOnsite();
			    	  double actualsp_offshore = obj.actualSpOffshore();
			    	  int slabrateonsite = obj.slabRateOnsite();
			    	  int slabrateoffshore = obj.slabRateOffshore();
			    	  double revenue = obj.revenue(location,actualsp);*/
			    	  gfd = "update KeepTracks3 set Resource_Name=" + resource_name + "SOW="+ sow + ",Comments="+comments +"Start_Date="+start_date+"End_Date="+end_date+"Rate_Set="+rate_set+"SAP_ID="+sap_id+"ID="+employee_id+"Location="+location+"Desig="+desig+"Working_Days="+workingdays+"Leaves=" + leaves +"Leave_dates=" + leave_dates+"w1='0',"+"w2='0',"+"w3='0',"+"w4='0',"+"w5='0',"+"Flag=" + flag +" where ID ="+ employee_id;
			    	  
			    	  statement.executeUpdate(gfd);
			      }
			   }catch(SQLException se)
			      {
			      
			      se.printStackTrace();
			      }
			   catch(Exception e)
			   {
			      e.printStackTrace();
			   }
			   finally
			   {
			      try
			      {
			         if(stmt!=null)
			            stmt.close();
				 if(rs!=null)
			    rs.close();
			      }
			      catch(SQLException se2){
			      }
			      try
			      {
			         if(conn!=null)
			            conn.close();
		      }
			      catch(SQLException se)
			      {
			         se.printStackTrace();
			      }//end finally try
			   }//end try 
		}
			   public ArrayList<KeepTrack3Bean> displayDataToUser()
				{
				  Connection conn = null;
				   Statement stmt = null;
				   ResultSet rs = null;
				   ArrayList<KeepTrack3Bean> custArr = new ArrayList<KeepTrack3Bean>();
				   try{
				     
				      Class.forName("com.mysql.jdbc.Driver");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      stmt = conn.createStatement();
				      String sql;
				      sql = "SELECT * FROM KeepTracks3";
				      rs = stmt.executeQuery(sql);
				      while(rs.next())
				      {
				     
				    	 KeepTrack3Bean projectData = new KeepTrack3Bean();
				    	 projectData.setresource_name(rs.getString("Resource_Name"));
				    	 projectData.setsow(rs.getString("SOW"));
				    	 projectData.setcomments(rs.getString("Comments"));
				    	 projectData.setstart_date(rs.getString("Start_Date"));
				    	 projectData.setend_date(rs.getString("End_Date"));
				    	 projectData.setrate_set(rs.getString("Rate_Set"));
				    	 projectData.setsap_id(rs.getString("SAP_ID"));
				    	 projectData.setemployee_id(rs.getString("Employee_ID"));
				    	 projectData.setrate(rs.getString("Rate"));
				    	 projectData.setlocation(rs.getString("Location"));
				    	 projectData.setdesig(rs.getString("Desig"));
				    	 projectData.setcat(rs.getString("Cat"));
				    	 projectData.setamount(rs.getString("Amount"));
				    	 projectData.setworkingdays(rs.getString("Working_Days"));
				    	 projectData.setleaves(rs.getString("Leaves"));
				    	 projectData.setleave_dates(rs.getString("Leave_Dates"));
				    	 projectData.setw1(rs.getString("w1"));
				    	 projectData.setw2(rs.getString("w2"));
				    	 projectData.setw3(rs.getString("w3"));
				    	 projectData.setw4(rs.getString("w4"));
				    	 projectData.setw5(rs.getString("w5"));
				    	 projectData.setflag(rs.getString("Flag"));
				    	 custArr.add(projectData);
				     }
				      

				      }catch(SQLException se)
				      {
				      
				      se.printStackTrace();
				      }
				   catch(Exception e)
				   {
				      e.printStackTrace();
				   }
				   finally
				   {
				      try
				      {
				         if(stmt!=null)
				            stmt.close();
					 if(rs!=null)
				    rs.close();
				      }
				      catch(SQLException se2){
				      }
				      try
				      {
				         if(conn!=null)
				            conn.close();
			      }
				      catch(SQLException se)
				      {
				         se.printStackTrace();
				      }
				   }
				   return custArr;
				
				   }
	}
	
