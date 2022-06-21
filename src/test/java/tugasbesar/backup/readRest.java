package tugasbesar.backup;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//perbaikan input sebelumnya 0/1
//penambahan exception
//diagram uml
public class readRest{
    
    private static FileInputStream fis;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Map<String, Integer> columns = new HashMap<>();
    private static String excelFilePath;
    public static double[] ArrayData = new double[29];
    public static String[] ArrayDataString = new String[26];
    
    public static double[] setArray(String type) throws Exception {
    	for (int i = 0; i <=25 ;i ++) {
    		ArrayData[i] = getCellData(type, i+1)    ;		
    	}
		return ArrayData;
    }
//    
//    public static String[] setArrayString() throws Exception {
//    	for (int i = 0; i <=25 ;i ++) {
//    		ArrayDataString[i] = getCellWeather("Cuaca", i+1)    ;		
//    	}
//		return ArrayDataString;
//    }
//    
    
    public static void setExcelFile() throws Exception {
        try {
            File f = new File(".//data//bmkg.xlsx");
            fis = new FileInputStream(".//data//bmkg.xlsx");
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet("Lembar2");
            if (sh == null) {
                sh = wb.createSheet("Lembar2");
            }
            excelFilePath = (".//data//bmkg.xlsx");
            //menambahkan semua dari kolom header ke hashmap
            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println();
        }
    }
//    public static String getCellWeather(int rownum, int colnum ) {
//    	try {
//    		cell = sh.getRow(rownum).getCell(colnum);
//    		String CellWeather = null;
//    		switch (cell.getCellType()){
//            case STRING:
//                CellWeather = cell.getStringCellValue();
//                break;
//            case NUMERIC: 
//                CellWeather = String.valueOf((double)cell.getNumericCellValue());
//                break;
//            case BOOLEAN:
//                CellWeather = Boolean.toString(cell.getBooleanCellValue());
//                break;
//        }
//    		return String.valueOf(CellWeather);
//			
//		} catch (Exception e) {
//			return (String) null;
//		}
//    }
//    public static String getCellWeather(String ColumnName, double rownum) throws Exception {
//    	return getCellWeather((int) rownum, columns.get(ColumnName) );
//    }
    public static Double getCellData(int rownum, int colnum) throws Exception{
        try{
            
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC: 
                    CellData = String.valueOf((Double)cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
			
            }
            return Double.valueOf(CellData);
        }catch (Exception e){
            return (double) 0;
        }
    }

    public static Double getCellData(String columnName, double rownum) throws Exception {
        return getCellData( (int)rownum, columns.get(columnName));
    }
    
    
public static void main(String[] args) throws Exception {
	
  try {
	  
	readRest.setExcelFile();
	setArray("Temperatur");
	System.out.println(ArrayData[6]);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
        
    }
}
//T		H	  W
//23	85	3,704 CERAH
//30	60	27,78 CERAH
//24	85	9,26 CERAH
//22	85	9,26 CERAH
//20	95	9,26 CERAH
//23	95	9,26 CERAH BERAWAN
//30	65	27,78 CERAH BERAWAN
//30	65	18,52 BERAWAN
//23	85	3,704 BERAWAN
//30	60	27,78 HUJAN  
//
//private static FileInputStream fis = null;
//private static XSSFWorkbook workbook = null;
//private static XSSFSheet sheet = null;
//private static XSSFRow row = null;
//private static XSSFCell cell = null;
//
//public readRest()  throws Exception{
//  fis = new FileInputStream(".//data//bmkg.xlsx");
//  workbook = new XSSFWorkbook(fis);
//  sheet = workbook.getSheet("ReadFile(2)");
//  fis.close();
//}
//
//public static void setStringTemp() {
//  
//  row = sheet.getRow(1);
//  cell = row.getCell(0);
//  cell.getNumericCellValue();
//}
//Temperatur Example 0= Temp, 1= Hum, 2, Wind, 3 Wth

//36
//public static void setString() throws Exception {
//double[] arr = new double[10];
//ArrayList<Double> getData = new ArrayList <Double>();
//for (int i = 1 ; i <= 10; i ++) {
//  getData.add(getCellData("Temperatur", i));
////    System.out.println(getData.get(i-1)); 
//  getData.get(i-1);
//}
//for (int i = 0; i <=arr.length; i++) {
//  arr[i] = arrFinal[i];
//}
////for (int i= 0 ; i <= 9; i++) {
////    arrTemp[i] = getTemp.get(i);
////}
//}
//   33   }
//for (int i = 0; i <=10; i++) {
//arrFinal = null;
//arr[i] = arrFinal [i];
//}
//for (int i= 0 ; i <= 9; i++) {
//arrTemp[i] = getTemp.get(i);