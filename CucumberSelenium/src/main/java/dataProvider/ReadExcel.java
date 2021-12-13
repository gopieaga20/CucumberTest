package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public String filepath;
	public int sheetIndex;

	public ReadExcel(String filepath, int sheetIndex) {
		this.filepath = filepath;
		this.sheetIndex = sheetIndex;
	}
	
	private XSSFSheet getSheet() throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);
		return sheet;		
	}
	
	public Map<String, Map<String,String>> getExcelasMap() throws IOException{
		XSSFSheet sheet = getSheet();
		
		 Map<String, Map<String,String>> completeSheetData = new HashMap<String, Map<String,String>>();
		 List<String> columnHeader = new ArrayList<String>();
		 Row row = sheet.getRow(0);
		 Iterator<Cell> cellIterator = row.cellIterator();
		 while(cellIterator.hasNext()) {
			 columnHeader.add(cellIterator.next().getStringCellValue()); // columnHeader.add("Username")
		 }
		 
		 
		 int rowCount = sheet.getLastRowNum();
		 int columnCount = row.getLastCellNum();
		 for(int i=1; i<=rowCount;i++) {
			 Map<String, String> singleRowData = new HashMap<String, String>();
			 Row row1 = sheet.getRow(i);
			 for(int j=0; j<columnCount; j++) {
				 Cell cell = row1.getCell(j);
				 singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
				 
			 }
			 completeSheetData.put(String.valueOf(i), singleRowData);
		 }
		 
		return completeSheetData;
		
	}

	private String getCellValueAsString(Cell cell) {
		String cellValue = null;
		
		switch(cell.getCellType()) {
		
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
			
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		
		case BLANK:
			cellValue = "BLANK";
		default:
			cellValue = "DEFAULT";			
		}
		
		return cellValue;
	}
}
