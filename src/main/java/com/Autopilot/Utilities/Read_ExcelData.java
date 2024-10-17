package com.Autopilot.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Read_ExcelData {

public static HashMap<String, String> main(String sheetname) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("./Data/EngagePlus_5.0_data.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet(sheetname);
		
		int rows = sheet.getLastRowNum();
		HashMap<String, String> data =  new HashMap<String, String>();
		
		for(int r=1; r<=rows; r++) {
			
			String key = sheet.getRow(r).getCell(0).getStringCellValue();
			String value = sheet.getRow(r).getCell(1).getStringCellValue();
			data.put(key, value);
		}
		return data;
	}
		public static String getData(String key, String sheetName) throws IOException{
			
			String sheetname = sheetName;
			HashMap<String, String> data1 = main(sheetname);
			String value = "";
			for(Map.Entry entry: data1.entrySet()) {
		
				if(entry.getKey().equals(key)) {
					value = (String) entry.getValue();
				}	
			}	
			return value;		
		}	
}
