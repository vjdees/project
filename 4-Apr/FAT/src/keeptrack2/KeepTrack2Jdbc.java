package keeptrack2;

//import keeptrack2.Keeptrack2;
import keeptrack2.MyBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KeepTrack2Jdbc 
{

	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/db";
	   static final String USER = "root";
	   static final String PASS = "root";
	   public void insertToDataBase(MyBean myBean)
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
			      String query="";
			      String name = "'" + myBean.getname() +"',";
			      int id =(int)Double.parseDouble(myBean.getID());
			      int workdayid =  (int)Double.parseDouble(myBean.getworkdayid());
			      String teammember = "'" + myBean.getteammember() +"',";
			      String comments = "'" + myBean.getcomments()+"',";
			      String sow = "'" + myBean.getsow()+"',";
			      String location = "'" + myBean.getlocation()+"',";
			      String stream = "'" + myBean.getstream()+"',";
			      String project = "'" + myBean.getproject()+"',";
			      String cat = "'" + myBean.getcat()+"',";
			      String week1 = "'" + myBean.getweek1()+"',";
			      String week2 = "'" + myBean.getweek2()+"',";
			      String week3 = "'" + myBean.getweek3()+"',";
			      String week4 = "'" + myBean.getweek4()+"',";
			      String week5 = "'" + myBean.getweek5()+"'";
			      String leaves = "'" + myBean.getleaves()+"',";
			      double workingdays = Double.parseDouble(myBean.getworkingdays());
			      double agreedsp =  Double.parseDouble(myBean.getagreedsp());
			     // double allocatedsp = Double.parseDouble(myBean.getallocatedsp());
			      KeepTrack2Calculations obj = new KeepTrack2Calculations();
			      try
			      {
			  
			    	  gfd ="INSERT INTO KeepTracks2(Project_ID_Name,ID,Workday_ID,Team_Member,Comments,SOW,Location,Stream,Project,Cat,Week1,Week2,Week3,Week4,Week5,Leaves,Working_Days,agreedsp) VALUES("+ name +  id + "," + workdayid +","+ teammember + comments + sow + location + stream + project + cat + week1 + week2 + week3 + week4 + week5 +"," + leaves + workingdays +"," + agreedsp+" )";
			    	  System.out.println(gfd);
			    	  statement.executeUpdate(gfd);
			    	  double pdtosp=obj.pdtosp2(workingdays,agreedsp);
			    	  System.out.println(pdtosp);
			    	  double actualsp =obj.actualsp(agreedsp,Double.parseDouble(myBean.getleaves()),pdtosp);
			    	  double allocatedsp_onsite = obj.allocatedSpOnsite();
			    	  double allocatedsp_offshore = obj.allocatedSpOffshore();
			    	  double actualsp_onsite = obj.actualSpOnsite();
			    	  double actualsp_offshore = obj.actualSpOffshore();
			    	  int slabrateonsite = obj.slabRateOnsite();
			    	  int slabrateoffshore = obj.slabRateOffshore();
			    	  double revenue = obj.revenue(location,actualsp);
			    	  query ="insert into KeepTracks2(pdtosp,actualsp,revenue) values("+pdtosp + ","+actualsp+","+revenue+")";
			    	  statement.executeUpdate(query);
			    	  System.out.println(gfd);
			    	  System.out.println(query);
			      }
			      catch(SQLException q)
			      {
			    	  double pdtosp=obj.pdtosp2(workingdays,agreedsp);
			    	  double actualsp =obj.actualsp(agreedsp,Double.parseDouble(myBean.getleaves()),pdtosp);
			    	  double allocatedsp_onsite = obj.allocatedSpOnsite();
			    	  double allocatedsp_offshore = obj.allocatedSpOffshore();
			    	  double actualsp_onsite = obj.actualSpOnsite();
			    	  double actualsp_offshore = obj.actualSpOffshore();
			    	  int slabrateonsite = obj.slabRateOnsite();
			    	  int slabrateoffshore = obj.slabRateOffshore();
			    	  double revenue = obj.revenue(location,actualsp);
			    	  gfd = "update KeepTracks2 set Project_ID_Name =" + name + "Workday_ID="+ workdayid + ",Team_Member="+teammember +"Comments="+comments+"SOW="+sow+"Location="+location+"Stream="+stream+"Project="+project+"Cat="+cat+"Week1='0',"+"Week2='0',"+"Week3='0',"+"Week4='0',"+"Week5='0',"+"Leaves=" + leaves +"Working_Days="+workingdays+",agreedsp=" +agreedsp+",pdtosp="+pdtosp +",actualsp="+actualsp+",revenue="+revenue+" where ID ="+ id;
			    	  System.out.println(gfd);
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
		public void deleteRecordFromDataBase(String ID)
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
			    	  gfd ="delete from keeptracks2 where ID="+ID;
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
