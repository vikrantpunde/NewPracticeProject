package BankTest.Utility;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel{
	public String[][] readExcel(String sheetName)  throws Exception {
		
	
	File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
	FileInputStream strm= new FileInputStream(file);
	//XSSFWorkbook for xlsx files, dependency poi-ooxml
	//XSSFWorkbook for xls file, dependency poi
	//For xls file 
	XSSFWorkbook book = new XSSFWorkbook(strm);
	
	Sheet sht=book.getSheet(sheetName);
	
	int rowcount = sht.getLastRowNum()-sht.getFirstRowNum();
	Row row= sht.getRow(1);
	int columnsCnt = row.getLastCellNum();
	
	String[][] data= new String[rowcount][columnsCnt];
	DataFormatter format = new DataFormatter();
	for(int i=0;i<rowcount;i++) {
		row= sht.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			data[i][j]=format.formatCellValue(row.getCell(j));
		}
	}
	book.close();
	return data;
	}
}
