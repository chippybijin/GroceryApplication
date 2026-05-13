package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import constant.Constant;
//import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;
	 static XSSFWorkbook w;
	 static XSSFSheet sh;

	 public static String readStringData(int row, int col, String sheet) throws IOException {
		 //f = new FileInputStream("C:\\Users\\chippy.s_inapp\\eclipse-workspace\\AutomationCourse\\src\\test\\resources\\GroceryApplication.xlsx");
	 // f = new FileInputStream("C:\\Users\\chippy.s_inapp\\eclipse-workspace\\AutomationCourse\\src\\test\\resources\\TestData.ods");
		f = new FileInputStream(Constant.TESTDATA);
		 w = new XSSFWorkbook(f);
	  sh = w.getSheet(sheet);
	  XSSFRow r = sh.getRow(row);
	  XSSFCell c = r.getCell(col);
	  return c.getStringCellValue();

	 }

	 public static String readIntegerData(int row, int col, String sheet) throws IOException {
		 //f = new FileInputStream("C:\\Users\\chippy.s_inapp\\eclipse-workspace\\AutomationCourse\\src\\test\\resources\\TestData.ods.xlsx");
		 f = new FileInputStream("C:\\Users\\chippy.s_inapp\\eclipse-workspace\\AutomationCourse\\src\\test\\resources\\GroceryApplication.xlsx");
	  w = new XSSFWorkbook(f);
	  sh = w.getSheet(sheet);
	  XSSFRow r = sh.getRow(row);
	  XSSFCell c = r.getCell(col);
	  int val = (int) c.getNumericCellValue(); //convert double to int using typecasting
	  return String.valueOf(val); //convert int to string using valueOf() method
	  
		
	 }
}
