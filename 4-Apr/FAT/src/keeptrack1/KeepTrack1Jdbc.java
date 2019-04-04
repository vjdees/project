package keeptrack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import keeptrack1.KeepTrack1Bean;



	public class KeepTrack1Jdbc 
	{

		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost:3306/db";
		   static final String USER = "root";
		   static final String PASS = "root";
		   public void insertToDataBase(KeepTrack1Bean keeptrack1Bean)
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
				      
				      String Resource_name = "'" +keeptrack1Bean.getresource_name() +"',";
				      String Team =","+keeptrack1Bean.getteam() +"',";
				      int SAP_ID =  (int)Double.parseDouble(keeptrack1Bean.getsap_id());
				      int Employee_ID = (int)Double.parseDouble(keeptrack1Bean.getemployee_id());
				      String Designation = "'" + keeptrack1Bean.getdesignation()+"',";
				      String Rate = "'" + keeptrack1Bean.getrate()+"',";
				      String Amount = "'" + keeptrack1Bean.getamount()+"',";
				      String Previous_Month_UBR_Days= "'"+keeptrack1Bean.getpre_mon_ubr_days()+"',";
				      String Previous_Month_UBR_Value= "'"+keeptrack1Bean.getpre_mon_ubr_value()+"',";
				      String Cat = "'" + keeptrack1Bean.getcat()+"',";
				      String Leaves = "'" + keeptrack1Bean.getleaves()+"',";
				      double Working_Days = Double.parseDouble(keeptrack1Bean.getworkingdays());
				      String Next_Month_UBR_Days = "'" + keeptrack1Bean.getnext_mon_ubr_days()+"',";
				      String Pas_Days = "'" + keeptrack1Bean.getpas_days()+"',";
				      String Pas_Received = "'" + keeptrack1Bean.getpas_received()+"',";
				      String Pas_Amount = "'" + keeptrack1Bean.getpas_amount()+"',";
				      String Discrepancy = "'" + keeptrack1Bean.getdiscrepancy()+"',";
				      String Discrepancy_Amount = "'" + keeptrack1Bean.getdicrepancy_amount()+"',";
				      String Discrepancy_Reason = "'" + keeptrack1Bean.getdiscrepancy_reason()+"',";
				      String Leave_dates = "'" + keeptrack1Bean.getleave_dates()+"',";
				      String w1 = "'" + keeptrack1Bean.getw1()+"',";
				      String w2 = "'" + keeptrack1Bean.getw2()+"',";
				      String w3 = "'" + keeptrack1Bean.getw3()+"',";
				      String w4 = "'" + keeptrack1Bean.getw4()+"',";
				      String w5 = "'" + keeptrack1Bean.getw5()+"'";
				      String Flag = "'" + keeptrack1Bean.getflag()+"',";
				      String Location = "'"+keeptrack1Bean.getlocation()+"',";
				      String Desig =   "'"+keeptrack1Bean.getdesig()+"',";
				      String Onsite_Working_Days = "'" + keeptrack1Bean.getonsite_workingdays()+"',";
				      String Offshore_Working_Days = "'" + keeptrack1Bean.getoffshore_workingdays()+"'";
				      try
				      {
				  
				    	  gfd ="INSERT INTO KeepTracks1(Resource_name,Team,SAP_ID,Employee_ID,Designation,Rate,Amount,leaves,workingdays,Leave_dates,w1,w2,w3,w4,w5,Location,Desig) VALUES("+ name +  id + "," + workdayid +","+ teammember + comments + sow + location + stream + project + cat + week1 + week2 + week3 + week4 + week5 +","+leaves+workingdays+","+agreedsp+")";
				    	  statement.executeUpdate(gfd);
				    	 

				      }
				      catch(SQLException q)
				      {
				    
				    	  
				    	  gfd = "update KeepTracks2 set Project_ID_Name =" + name + "Workday_ID="+ workdayid + ",Team_Member="+teammember +"Comments="+comments+"SOW="+sow+"Location="+location+"Stream="+stream+"Project="+project+"Cat="+cat+"Week1='0',"+"Week2='0',"+"Week3='0',"+"Week4='0',"+"Week5='0',"+"Leaves=" + leaves +"Working_Days="+workingdays+",agreedsp=" +agreedsp+",pdtosp="+pdtosp +",actualsp="+actualsp+",revenue="+revenue+" where ID ="+ id;
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
		   public ArrayList<MyBean> displayDataToUser()
			{
			  Connection conn = null;
			   Statement stmt = null;
			   ResultSet rs = null;
			   ArrayList<MyBean> custArr = new ArrayList<MyBean>();
			   try{
			     
			      Class.forName("com.mysql.jdbc.Driver");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM KeepTracks2";
			      rs = stmt.executeQuery(sql);
			      while(rs.next())
			      {
			     
			    	 MyBean projectData = new MyBean();
			    	 projectData.setname(rs.getString("Project_ID_Name"));
			    	 projectData.setID(rs.getString("ID"));
			    	 projectData.setworkdayid(rs.getString("Workday_ID"));
			    	 projectData.setteammember(rs.getString("Team_Member"));
			    	 projectData.setcomments(rs.getString("Comments"));
			    	 projectData.setsow(rs.getString("SOW"));
			    	 projectData.setlocation(rs.getString("Location"));
			    	 projectData.setstream(rs.getString("Stream"));
			    	 projectData.setproject(rs.getString("Project"));
			    	 projectData.setcat(rs.getString("Cat"));
			    	 projectData.setweek1(rs.getString("Week1"));
			    	 projectData.setweek2(rs.getString("Week2"));
			    	 projectData.setweek3(rs.getString("Week3"));
			    	 projectData.setweek4(rs.getString("Week4"));
			    	 projectData.setweek5(rs.getString("Week5"));
			    	 projectData.setleaves(rs.getString("Leaves"));
			    	 projectData.setworkingdays(rs.getString("Working_Days"));
			    	 projectData.setpdtosp(rs.getString("pdtosp"));
			    	 projectData.setagreedsp(rs.getString("agreedsp"));
			    	 projectData.setactualsp(rs.getString("actualsp"));
			    	 projectData.setrevenue(rs.getString("revenue"));
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
			public void deleteRecordFromDataBase(String id)
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
				      try
				      {
				    	  gfd ="delete from keeptracks2 where ID="+id;
				    	  statement.executeUpdate(gfd);
				      }
				      catch(SQLException q)
				      {
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

	}

