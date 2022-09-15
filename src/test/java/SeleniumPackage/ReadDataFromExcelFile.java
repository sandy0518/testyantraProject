package SeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelFile {

	public static void main(String [] args) throws Exception {
		FileInputStream fis=new FileInputStream("./SDET-8.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRNum = sheet.getLastRowNum();
		for(int i=0;i<=lastRNum;i++) {
			String cellValue = sheet.getRow(i).getCell(2).getStringCellValue();
			if(cellValue.equals("IT")) {
				System.out.println(sheet.getRow(i).getCell(1).getStringCellValue());
			}
		}	
	}
}
