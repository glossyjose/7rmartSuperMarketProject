package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	public static String getStringData(int a, int b, String sheet) throws IOException {
		f=new FileInputStream(Constant.TESTDATAFILE);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		f=new FileInputStream(Constant.TESTDATAFILE);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int x=(int)c.getNumericCellValue();
		return String.valueOf(x);
	}
	
}
