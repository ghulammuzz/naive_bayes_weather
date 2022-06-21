package ori;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class readRest{
	
	private static FileInputStream fis;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Map<String, Integer> columns = new HashMap<>();
    private static String excelFilePath;
    public static double[] arrFinal = new double[25];
    
    
    public static double[] setString(String type) throws Exception {

    	for (int i = 0 ; i <= 25; i ++) {
        	getData.add(getCellData(type, i+1));
//        	System.out.println(getData.get(i-1)); 

        }
    	for (int i = 0; i <=25; i++) {
    		arr[i] = arrFinal[i];
    	}
//    	for (int i= 0 ; i <= 9; i++) {
//			arrTemp[i] = getTemp.get(i);
//    	}
		return arrFinal;
    }
//    public static void setString() throws Exception {
//    	double[] arr = new double[10];
//    	ArrayList<Double> getData = new ArrayList <Double>();
//    	for (int i = 1 ; i <= 10; i ++) {
//        	getData.add(getCellData("Temperatur", i));
////        	System.out.println(getData.get(i-1)); 
//        	getData.get(i-1);
//        }
//    	for (int i = 0; i <=arr.length; i++) {
//    		arr[i] = arrFinal[i];
//    	}
////    	for (int i= 0 ; i <= 9; i++) {
////			arrTemp[i] = getTemp.get(i);
////    	}
//    }
    
    public void setExcelFile() throws Exception {
        try {
            File f = new File(".//data//bmkg.xlsx");
            fis = new FileInputStream(".//data//bmkg.xlsx");
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet("Lembar2");
            if (sh == null) {
                sh = wb.createSheet("Lembar2");
            }
            this.excelFilePath = (".//data//bmkg.xlsx");
            //menambahkan semua dari kolom header ke hashmap
            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static Double getCellData(int rownum, int colnum) throws Exception{
        try{
        	
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC: 
                    CellData = String.valueOf((double)cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
            }
            return Double.valueOf(CellData);
        }catch (Exception e){
            return null;
        }
    }

    public static Double getCellData(String columnName, int rownum) throws Exception {
        return getCellData(rownum, columns.get(columnName));
    }
public static void main(String[] args) throws Exception {
	readRest hehe = new readRest();
	hehe.setExcelFile();
	setString("Kecepatan Angin");
        
    }
}


//
//private static FileInputStream fis = null;
//private static XSSFWorkbook workbook = null;
//private static XSSFSheet sheet = null;
//private static XSSFRow row = null;
//private static XSSFCell cell = null;
//
//public readRest()  throws Exception{
//	fis = new FileInputStream(".//data//bmkg.xlsx");
//	workbook = new XSSFWorkbook(fis);
//	sheet = workbook.getSheet("ReadFile(2)");
//	fis.close();
//}
//
//public static void setStringTemp() {
//	
//	row = sheet.getRow(1);
//	cell = row.getCell(0);
//	cell.getNumericCellValue();
//}
//Temperatur Example 0= Temp, 1= Hum, 2, Wind, 3 Wth