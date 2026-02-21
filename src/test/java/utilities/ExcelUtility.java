package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * This class is responsible for reading data from Excel file.
 * It uses Apache POI library.
 */

public class ExcelUtility {

	public FileInputStream fi;
	public XSSFWorkbook wb;
	public Sheet sh;

	// Constructor → Load Excel File
	public ExcelUtility(String excelPath) throws IOException {

		fi = new FileInputStream(excelPath);
		wb = new XSSFWorkbook(fi);
	}

	// Get Total Row Count
	public int getRowCount(String sheetName) {

		sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();  // excludes header row
	}

	// Get Total Cell Count
	public int getCellCount(String sheetName, int rowNum) {

		sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		return row.getLastCellNum();
	}

	// Get Cell Data
	public String getCellData(String sheetName, int rowNum, int colNum) {

		sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter(); 
		return formatter.formatCellValue(cell);
	}
}
