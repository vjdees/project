package keeptrack2;

import keeptrack2.KeepTrack2Jdbc;
import keeptrack2.ExcelReader;

//import hello.Jdbc;
//import hello.MyBean;

//import hello.Jdbc;
import keeptrack2.MyBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Keeptrack2Servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try (PrintWriter out = response.getWriter()) 
		  {
		  KeepTrack2Jdbc jdbc_obj = new KeepTrack2Jdbc();
		  ExcelReader obj = new ExcelReader();
		   try 
		     {
			  obj.excel();
		     }
	   catch (SQLException e) 
		{
        	e.printStackTrace();
		}
		   response.setContentType("application/json");
           String json = new Gson().toJson(jdbc_obj.displayDataToUser());
		   response.getWriter().write(json);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
        MyBean myBean = gson.fromJson(reader, MyBean.class);
		KeepTrack2Jdbc keeptrack2jdbc_obj = new KeepTrack2Jdbc();
		keeptrack2jdbc_obj.insertToDataBase(myBean);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		    PrintWriter out = response.getWriter();
		    BufferedReader reader = request.getReader();
			Gson gson = new Gson();
	        MyBean myBean = gson.fromJson(reader, MyBean.class);

	 
	    try 
	    {
	    	KeepTrack2Jdbc ab1 = new KeepTrack2Jdbc();
	    	ab1.deleteRecordFromDataBase(myBean.getID());
	     

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}


