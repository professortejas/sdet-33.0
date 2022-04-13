package generic_repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	static Workbook wb;
	public static void openExcel(String path) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		wb=WorkbookFactory.create(fis);
	}
	
	public static String fetchSingleData(String sheetName, int rowNo, int cellNo) {
		Sheet sheet=wb.getSheet(sheetName);
		String data = sheet.getRow(rowNo).getCell(cellNo).toString();
		return data;
	}
	
	public static void writeDataInNewRow(String sheetName, int rowNo, int cellNo, String path) throws IOException {
		wb.getSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(sheetName);
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
	}
	
	public static void writeDataInExistingRow(String sheetName, int rowNo, int cellNo, String path) throws IOException {
		wb.getSheet(sheetName).getRow(rowNo).createCell(cellNo).setCellValue(sheetName);
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
	}
	
	public static void closeExcel() throws IOException {
		wb.close();
	}
	
	public static Object[][] fetchMultipleData(String sheetName){
		Sheet sh = wb.getSheet(sheetName);
		Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 0; i <sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
				arr[i][j]=sh.getRow(i+1).getCell(j).toString();
			}
			
		}
		return arr;
	}
}
