package com.flightbooking.reusablecomponents;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelManager {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	public static final String Path_TestData = "./test-data/";
	public static final String File_TestData = "TestData.xlsx";


	public static void setExcelFile( String SheetName) throws Exception {
		try {
			String path = Path_TestData + File_TestData;
			FileInputStream ExcelFile = new FileInputStream(path);
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static int findRow( String cellContent) throws Exception {
		int totalrows = excelWSheet.getPhysicalNumberOfRows();
        for (int i = 1; i <= totalrows; i++) {
            int colNum = 0;
            String value = getCellData(i,colNum);
            if (value.equals(cellContent)) {
                return i;
            }
        }
        return 0;
    }
	
	public static String getCellDataValue(String colName, String rowValue) throws Exception {
		int rowNum = findRow(rowValue);
		try {
	         XSSFRow row = excelWSheet.getRow(0);
	         int colNum = 0;
			for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                    colNum = i;
                    break;
                }
            }
			row = excelWSheet.getRow(rowNum);
			XSSFCell cell = row.getCell(colNum);
			if (cell == null) 
                return "";
                else
			return String.valueOf(cell.toString());			
		} catch (Exception e) {
			return "";
		}
	}
}
