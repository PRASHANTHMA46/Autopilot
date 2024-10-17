package com.Autopilot.Utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;

public class ExcelData {
	
	public static String getData(String sheetname, int row,int cell) throws EncryptedDocumentException, IOException
	{		
		try {
			FileInputStream fis= new FileInputStream("./Data/autopilot.xlsx");
			Sheet sh= WorkbookFactory.create(fis).getSheet(sheetname);
			String data=sh.getRow(row).getCell(cell).toString();
			return data;
		} 
		catch (FileNotFoundException e)
		{		
			return "File not found";
		}		
	}
}
