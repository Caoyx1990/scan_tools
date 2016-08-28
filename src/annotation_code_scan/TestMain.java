package annotation_code_scan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {
	private static final Logger logger = LoggerFactory.getLogger(TestMain.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("config/log4j.properties");
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row;
		for(int i = 0; i < 100; i ++) {
			row = sheet.createRow(i);
			row.createCell(1).setCellValue("Test");
		}
		String filename = "D:/test.xlsx";
		logger.info(filename);
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
