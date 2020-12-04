package Selenium_Framework_Assertions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ReadExcel {
	
	@Test
	public void testReadingExcel() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\STELLA\\Documents\\DemoFile.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIt =sheet.iterator();
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			Iterator<Cell> cellIt = row.cellIterator();
			while(cellIt.hasNext()) {
				Cell cell = cellIt.next();
				System.out.println(cell.toString()+";");
				
			}
			System.out.println("..");
		}
		workbook.close();
		fs.close();
		
		}
		
	}


