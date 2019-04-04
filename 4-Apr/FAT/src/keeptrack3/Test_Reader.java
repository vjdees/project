package keeptrack3;
import keeptrack3.KeepTrack3Jdbc;
import keeptrack3.KeepTrack3Bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test_Reader {

	/**
	 * @param args
	 */
	public ArrayList<KeepTrack3Bean> excel() throws IOException,FileNotFoundException,SQLException
    {
	    
		FileInputStream centrica_ActualDigital3=new FileInputStream("C:\\Users\\765707\\Desktop\\sample.xlsm");
		XSSFWorkbook centrica_ActualDigital_wb=new XSSFWorkbook(centrica_ActualDigital3);
		XSSFSheet Sheet1=centrica_ActualDigital_wb.getSheetAt(1);
		//System.out.println(centrica_ActualDigital_wb.getSheetAt(1));
	    ArrayList<KeepTrack3Bean> array = new ArrayList<KeepTrack3Bean>();
	    KeepTrack3Jdbc jdbc_obj = new KeepTrack3Jdbc();
	   //String cell2 = Sheet1.getRow(0).getCell(32).toString();
	   System.out.println(Sheet1.getRow(0).getCell(32));
	  // KeepTrack3Bean1 projectData = new KeepTrack3Bean();
	    KeepTrack3Bean projectData = new KeepTrack3Bean();

	 
	   for(int i=3;;i++)
		  {
			  String cell1 = Sheet1.getRow(i).getCell(0).toString();
		         if(cell1 == null || cell1=="") 
		         {
		        	System.out.println("break looop");
		        	 break;
		        	
		         }  else{
		        	 projectData.settotalworkingdays(Sheet1.getRow(1).getCell(13).toString());
			    	 projectData.setresource_name(Sheet1.getRow(i).getCell(0).toString());
			    	 //projectData.setresource_name(Sheet1.getRow(i).getCell(0)!=null ? Sheet1.getRow(i).getCell(0).toString(): "");
			    	// System.out.println(Sheet1.getRow(i).getCell(0).toString());
			    	//projectData.setleave_dates(Sheet1.getRow(i).getCell(15)!=null ? Sheet1.getRow(i).getCell(15).toString(): "");
			    	projectData.setsow(Sheet1.getRow(i).getCell(1).toString());
			    	// System.out.println(Sheet1.getRow(i).getCell(1).toString());
			    	// projectData.setsow(Sheet1.getRow(i).getCell(1)!=null ? Sheet1.getRow(i).getCell(1).toString(): "");
			    	 projectData.setcomments(Sheet1.getRow(i).getCell(2).toString());
			    	 //projectData.setcomments(Sheet1.getRow(i).getCell(2)!=null ? Sheet1.getRow(i).getCell(2).toString(): "");
			    	 //System.out.println(Sheet1.getRow(i).getCell(2));
			    	 projectData.setstart_date(Sheet1.getRow(i).getCell(3).toString());
			    	 //projectData.setstart_date(Sheet1.getRow(i).getCell(3)!=null ? Sheet1.getRow(i).getCell(3).toString(): "");
			    	 projectData.setend_date(Sheet1.getRow(i).getCell(4).toString());
			    	 //projectData.setend_date(Sheet1.getRow(i).getCell(4)!=null ? Sheet1.getRow(i).getCell(4).toString(): "");
			    	 projectData.setrate_set(Sheet1.getRow(i).getCell(5).toString());
			    	 //projectData.setrate_set(Sheet1.getRow(i).getCell(5)!=null ? Sheet1.getRow(i).getCell(5).toString(): "");
			    	// projectData.setsap_id(Sheet1.getRow(i).getCell(6).toString());
			    	 projectData.setsap_id((Sheet1.getRow(i).getCell(6).getRawValue() !=null ?Sheet1.getRow(i).getCell(6).toString(): "0.00"));
			    	// projectData.setemployee_id(Sheet1.getRow(i).getCell(7).toString());
			    	 projectData.setemployee_id(Sheet1.getRow(i).getCell(7).getRawValue()!=null ? Sheet1.getRow(i).getCell(7).toString(): "0.00");
			    	 projectData.setrate(Sheet1.getRow(i).getCell(8).toString());
			    	 //projectData.setrate(Sheet1.getRow(i).getCell(8)!=null ? Sheet1.getRow(i).getCell(8).toString(): "");
			    	 projectData.setlocation(Sheet1.getRow(i).getCell(9).toString());
			    	 //projectData.setlocation(Sheet1.getRow(i).getCell(9)!=null ? Sheet1.getRow(i).getCell(9).toString(): "");
			    	 projectData.setdesig(Sheet1.getRow(i).getCell(10).toString());
			    	 //projectData.setdesig(Sheet1.getRow(i).getCell(10)!=null ? Sheet1.getRow(i).getCell(10).toString(): "");
			    	 projectData.setcat(Sheet1.getRow(i).getCell(11).toString());
			    	 //projectData.setcat(Sheet1.getRow(i).getCell(11)!=null ? Sheet1.getRow(i).getCell(11).toString(): "");
			    	 projectData.setamount(Sheet1.getRow(i).getCell(12).toString());
			    	 //projectData.setamount(Sheet1.getRow(i).getCell(12)!=null ? Sheet1.getRow(i).getCell(12).toString(): "");
			    	 projectData.setworkingdays(Sheet1.getRow(i).getCell(13).toString());
			    	//projectData.setworkingdays(Sheet1.getRow(i).getCell(13)!=null ? Sheet1.getRow(i).getCell(13).toString(): "");
			         projectData.setleaves(Sheet1.getRow(i).getCell(14).toString());
			         //projectData.setleaves(Sheet1.getRow(i).getCell(14)!=null ? Sheet1.getRow(i).getCell(14).toString(): "");
			        // projectData.setleave_dates(Sheet1.getRow(i).getCell(15).getRawValue()!=null ? Sheet1.getRow(i).getCell(15).toString(): "0.00");
			    	 projectData.setleave_dates(Sheet1.getRow(i).getCell(15)!=null ? Sheet1.getRow(i).getCell(15).toString(): "");
			    	
			    	 //projectData.setworkingdays(Sheet1.getRow(i).getCell(16).toString());
			    	 //projectData.setworkingdays(Sheet1.getRow(i).getCell(16)!=null ? Sheet1.getRow(i).getCell(16).toString():"");
			    	//projectData.setw1(Sheet1.getRow(i).getCell(16).toString());
			    	 projectData.setw1(Sheet1.getRow(i).getCell(16)!=null ? Sheet1.getRow(i).getCell(16).toString(): "");
			    	// projectData.setw2(Sheet1.getRow(i).getCell(17).toString());
			    	projectData.setw2(Sheet1.getRow(i).getCell(17)!=null ? Sheet1.getRow(i).getCell(17).toString(): "");
			    	// projectData.setw3(Sheet1.getRow(i).getCell(18).toString());
			    	projectData.setw3(Sheet1.getRow(i).getCell(18)!=null ? Sheet1.getRow(i).getCell(18).toString(): "");
			    	 //projectData.setw4(Sheet1.getRow(i).getCell(19).toString());
			    	projectData.setw4(Sheet1.getRow(i).getCell(19)!=null ? Sheet1.getRow(i).getCell(19).toString(): "");
			    	 //projectData.setw5(Sheet1.getRow(i).getCell(20).toString());
			    	 projectData.setw5(Sheet1.getRow(i).getCell(20)!=null ? Sheet1.getRow(i).getCell(20).toString(): "");
			    	 //projectData.setflag(Sheet1.getRow(i).getCell(21).toString());
			    	 projectData.setflag(Sheet1.getRow(i).getCell(21)!=null ? Sheet1.getRow(i).getCell(21).toString(): "");
			         jdbc_obj.insertToDataBase(projectData);
		         }
			         
		  }
	    
		 
		  centrica_ActualDigital_wb.close();
		
	   return array;

	}
}
