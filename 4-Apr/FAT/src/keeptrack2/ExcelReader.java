package keeptrack2;

import keeptrack2.KeepTrack2Jdbc;
import keeptrack2.MyBean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
    public ArrayList<MyBean> excel() throws IOException,FileNotFoundException,SQLException
    {
	    
		FileInputStream centrica_ActualDigital=new FileInputStream("D:\\Project\\CentricaDigitalActuals-Jan2019-Finalv4.xlsm");
		XSSFWorkbook centrica_ActualDigital_wb=new XSSFWorkbook(centrica_ActualDigital);
		XSSFSheet Sheet2=centrica_ActualDigital_wb.getSheetAt(2);
	    ArrayList<MyBean> array = new ArrayList<MyBean>();
	    KeepTrack2Jdbc jdbc_obj = new KeepTrack2Jdbc();
	    for(int i=4;;i++)
		  {
			  String cell1 = Sheet2.getRow(i+1).getCell(0).toString();
			  
				     MyBean projectData = new MyBean();
			    	 projectData.setname(Sheet2.getRow(i).getCell(0).toString());
			    	 projectData.setID(Sheet2.getRow(i).getCell(1).toString());
			    	 projectData.setworkdayid(Sheet2.getRow(i).getCell(2).toString());
			    	 projectData.setteammember(Sheet2.getRow(i).getCell(3).toString());
			    	 projectData.setcomments(Sheet2.getRow(i).getCell(4).toString());
			    	 projectData.setsow(Sheet2.getRow(i).getCell(5).toString());
			    	 projectData.setlocation(Sheet2.getRow(i).getCell(6).toString());
			    	 projectData.setstream(Sheet2.getRow(i).getCell(7).toString());
			    	 projectData.setproject(Sheet2.getRow(i).getCell(8).toString());
			    	 projectData.setcat(Sheet2.getRow(i).getCell(9).toString());
			    	 projectData.setleaves(Sheet2.getRow(i).getCell(15).toString());
			    	 projectData.setworkingdays(Sheet2.getRow(i).getCell(16).toString());
			    	 projectData.setagreedsp(Sheet2.getRow(i).getCell(18).toString());
			    	 //projectData.setallocatedsp(Sheet2.getRow(i).getCell(19).toString());
 			    	 jdbc_obj.insertToDataBase(projectData);
			   if(cell1 == null || cell1=="") 
		    	 {
		    	 break;
		    	 }  
			   
		  }
		 
		  centrica_ActualDigital_wb.close();
		
	   return array;

	}


}
