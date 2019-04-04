package keeptrack3;
import keeptrack3.Test_Reader;
import keeptrack3.KeepTrack3Jdbc;
import keeptrack3.KeepTrack3Bean;


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
public class Keeptrack3Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
   
    public Keeptrack3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (PrintWriter out = response.getWriter()) 
		  {
		  KeepTrack3Jdbc jdbc_obj = new KeepTrack3Jdbc();
		  Test_Reader obj = new Test_Reader();
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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
        KeepTrack3Bean keeptrack3Bean = gson.fromJson(reader, KeepTrack3Bean.class);
		KeepTrack3Jdbc keeptrack3jdbc_obj = new KeepTrack3Jdbc();
		keeptrack3jdbc_obj.insertToDataBase(keeptrack3Bean);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
