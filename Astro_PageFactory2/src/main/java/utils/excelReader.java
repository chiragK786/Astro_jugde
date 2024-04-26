package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class excelReader {
	   public static String[][] readExcelData(String filePath) throws IOException {
	        FileInputStream inputStream = new FileInputStream(new String(filePath));
	        Workbook workbook = WorkbookFactory.create(inputStream);
	        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
	        
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getLastCellNum();
	        
	        String[][] data = new String[rowCount][colCount];
	        
	        for (int i = 0; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                if (cell != null) {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            data[i][j] = cell.getStringCellValue();
	                            break;
	                        case NUMERIC:
	                            if (DateUtil.isCellDateFormatted(cell)) {
	                                data[i][j] = cell.getDateCellValue().toString();
	                            } else {
	                                data[i][j] = Double.toString(cell.getNumericCellValue());
	                            }
	                            break;
	                        case BOOLEAN:
	                            data[i][j] = Boolean.toString(cell.getBooleanCellValue());
	                            break;
	                        default:
	                            data[i][j] = "";
	                    }
	                } else {
	                    data[i][j] = "";
	                }
	            }
	        }
	        
	        workbook.close();
	        inputStream.close();
	        
	        return data;
	    }
	
}
	