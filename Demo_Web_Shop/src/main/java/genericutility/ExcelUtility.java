package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	/**
	 * This Methods will read String data from excel file and return value to the caller
	 * @param sheetName, rowIndex , colIndex
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
     */
	
	public String getStringDataFromExcel(String sheetName,int rowIndex, int colIndex) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}
	
	/**
	 * This Methods will read Number data from excel file and return value to the caller
	 * @param sheetName, rowIndex , colIndex
	 * @return Double
	 * @throws IOException
	 * @throws EncryptedDocumentException
     */
	
	public double getNumberDataFromExcel(String sheetName,int rowIndex, int colIndex) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	 return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}
	
	/**
	 * This Methods will read Boolean Data from excel file and return value to the caller
	 * @param sheetName, rowIndex , colIndex
	 * @return Boolean
	 * @throws IOException
	 * @throws EncryptedDocumentException
     */
	
	public boolean getBooleanDataFromExcel(String sheetName,int rowIndex, int colIndex) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}
	
	/**
	 * This Methods will read DateAndTime from excel file and return value to the caller
	 * @param sheetName, rowIndex , colIndex
	 * @return Date
	 * @throws IOException
	 * @throws EncryptedDocumentException
     */
	public Date getDateAndTimeDataFromExcel(String sheetName,int rowIndex, int colIndex) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getDateCellValue();
	}

}
