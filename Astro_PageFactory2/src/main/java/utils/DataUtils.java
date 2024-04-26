package utils;

import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataUtils {
	  @DataProvider(name = "excelData")
	    public Object[][] getDataFromExcel() throws IOException {
	        String filePath = "//Users//chiragkhanduja//eclipse-workspace//Astro_DDT//resources//Astrocase.xlsx";
	        FileInputStream inputStream = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header row
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                if (cell != null) {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            data[i - 1][j] = cell.getStringCellValue();
	                            break;
	                        case NUMERIC:
	                            if (DateUtil.isCellDateFormatted(cell)) {
	                                data[i - 1][j] = cell.getDateCellValue().toString();
	                            } else {
	                                data[i - 1][j] = Double.toString(cell.getNumericCellValue());
	                            }
	                            break;
	                        case BOOLEAN:
	                            data[i - 1][j] = Boolean.toString(cell.getBooleanCellValue());
	                            break;
	                        default:
	                            data[i - 1][j] = "";
	                    }
	                } else {
	                    data[i - 1][j] = "";
	                }
	            }
	        }

	        workbook.close();
	        inputStream.close();

	        return data;
	    }

}
