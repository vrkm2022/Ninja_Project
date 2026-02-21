package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

/*
 * This class contains multiple DataProviders
 * One for each test case.
 */

public class DataProviders {

	String path = System.getProperty("user.dir") + "/testData/RegisterData.xlsx";

	// 🔹 Mandatory Fields Data
	@DataProvider(name="MandatoryData")
	public Object[][] getMandatoryData() throws IOException {

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalRows = xlutil.getRowCount("MandatoryData");
		int totalCols = xlutil.getCellCount("MandatoryData", 1);

		Object data[][] = new Object[totalRows][totalCols];

		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				data[i-1][j] = xlutil.getCellData("MandatoryData", i, j);
			}
		}
		return data;
	}

	// 🔹 All Fields Data
	@DataProvider(name="AllFieldsData")
	public Object[][] getAllFieldsData() throws IOException {

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalRows = xlutil.getRowCount("AllFieldsData");
		int totalCols = xlutil.getCellCount("AllFieldsData", 1);

		Object data[][] = new Object[totalRows][totalCols];

		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				data[i-1][j] = xlutil.getCellData("AllFieldsData", i, j);
			}
		}
		return data;
	}

	// 🔹 Negative Test Data
	@DataProvider(name="NegativeData")
	public Object[][] getNegativeData() throws IOException {

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalRows = xlutil.getRowCount("NegativeData");

		Object data[][] = new Object[totalRows][1];

		for(int i=1;i<=totalRows;i++) {
			data[i-1][0] = xlutil.getCellData("NegativeData", i, 0);
		}
		return data;
	}
}
