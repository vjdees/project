package keeptrack3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_Reader {

	/**
	 * @param args
	 */
	public ArrayList<KeepTrack3Bean> excel() throws IOException,FileNotFoundException,SQLException
    {
	    
		FileInputStream centrica_ActualDigital3=new FileInputStream("D:\\Project\\testworkbook.xlsx");
		XSSFWorkbook centrica_ActualDigital_wb=new XSSFWorkbook(centrica_ActualDigital3);
		XSSFSheet Sheet3=centrica_ActualDigital_wb.getSheetAt(0);
		System.out.println(centrica_ActualDigital_wb.getSheetAt(0));
	    ArrayList<KeepTrack3Bean> array = new ArrayList<KeepTrack3Bean>();
	    KeepTrack3Jdbc jdbc_obj = new KeepTrack3Jdbc();
	    for(int i=3;;i++)
		  {
			  String cell1 = Sheet3.getRow(i+1).getCell(0).toString();
			  
				     KeepTrack3Bean projectData = new KeepTrack3Bean();
			    	 projectData.setresource_name(Sheet3.getRow(i).getCell(1).toString());
			    	 System.out.println(Sheet3.getRow(i).getCell(0).toString());
			    	 projectData.setsow(Sheet3.getRow(i).getCell(1).toString());
			    	 projectData.setcomments(Sheet3.getRow(i).getCell(2).toString());
			    	 projectData.setstart_date(Sheet3.getRow(i).getCell(3).toString());
			    	 projectData.setend_date(Sheet3.getRow(i).getCell(4).toString());
			    	 projectData.setrate_set(Sheet3.getRow(i).getCell(5).toString());
			    	 projectData.setsap_id(Sheet3.getRow(i).getCell(6).toString());
			    	 projectData.setemployee_id(Sheet3.getRow(i).getCell(7).toString());
			    	 projectData.setrate(Sheet3.getRow(i).getCell(8).toString());
			    	 projectData.setlocation(Sheet3.getRow(i).getCell(9).toString());
			    	 projectData.setdesig(Sheet3.getRow(i).getCell(10).toString());
			    	 projectData.setcat(Sheet3.getRow(i).getCell(11).toString());
			    	 projectData.setamount(Sheet3.getRow(i).getCell(12).toString());
			    	 projectData.setworkingdays(Sheet3.getRow(i).getCell(13).toString());
			         projectData.setleaves(Sheet3.getRow(i).getCell(14).toString());
			    	 projectData.setleave_dates(Sheet3.getRow(i).getCell(15).toString());
			    	 projectData.setworkingdays(Sheet3.getRow(i).getCell(16).toString());
			    	 projectData.setw1(Sheet3.getRow(i).getCell(18).toString());
			    	 projectData.setw2(Sheet3.getRow(i).getCell(19).toString());
			    	 projectData.setw3(Sheet3.getRow(i).getCell(20).toString());
			    	 projectData.setw4(Sheet3.getRow(i).getCell(21).toString());
			    	 projectData.setw5(Sheet3.getRow(i).getCell(22).toString());
			    	 projectData.setflag(Sheet3.getRow(i).getCell(23).toString());
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
