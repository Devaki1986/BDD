package RestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class testdatautil {
	
	public static Workbook book;
	public static Sheet sheet;
	public static String path ="D:\\Workspace\\RestAssuredBDD\\src\\test\\java\\Testdata.xlsx";
	
	public static Object[][] getdata(String sheetname) {
		
		Object[][] data = null;
		try {
			
		
		FileInputStream ip = new FileInputStream(path);
		book = WorkbookFactory.create(ip);
		sheet = book.getSheet(sheetname);
		
		
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i =0; i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			
			}
			}
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(data);
		
		return data;

}
}
