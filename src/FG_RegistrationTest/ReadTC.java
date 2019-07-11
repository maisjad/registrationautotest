package FG_RegistrationTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTC {
	static String [][]Data=new String [64][64];

	static String[][] fileopen(String filename,String sheetname){
		  
		  File file = new File(filename); 
		   FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		    Workbook WB = null;
			try {
				WB = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    Sheet sh = WB.getSheet(sheetname);
          int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	        int colcount=sh.getRow(0).getLastCellNum();
	       
		    for (int i = 0; i < rowCount+1; i++) {
		    
		    	
		        Row row = sh.getRow(i);
		        System.out.println();
          for (int j = 0; j < row.getLastCellNum(); j++) {
          	try{ 
          		
          		Data[i][j]=row.getCell(j).getStringCellValue();
          		System.out.print(Data[i][j]+"|| ");
          		 }
          	 
          	 catch (IllegalStateException e){
          		row.getCell(j).setCellType(CellType.STRING);
           		
          		
          		 
          		 Data[i][j]= row.getCell(j).getStringCellValue();}
          	System.out.print(Data[i][j]+"|| ");
          		 
          	 }
          	
          	
             }
			return Data;}
		
		
		
	}
  

