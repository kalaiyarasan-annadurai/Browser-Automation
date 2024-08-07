package reconnect.open.access.browser.automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	// creating the objects
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

//Counting rows
	public static int getRowCount(String file1, String sheet) throws IOException {
		fi = new FileInputStream(file1);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rownum = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rownum;

	}

	/*
	 * public static int getRowCount(String xlfile,String xlsheet) throws
	 * IOException { fi=new FileInputStream(xlfile); wb=new XSSFWorkbook(fi);
	 * ws=wb.getSheet(xlsheet); int rowcount=ws.getLastRowNum(); wb.close();
	 * fi.close(); return rowcount; }
	 */
	public static int getCellcount(String file1, String sheet, int rowncount) throws IOException {
		fi = new FileInputStream(file1);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowncount);
		int cellnum = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellnum;

	}

	/*
	 * public static int getCellCount(String xlfile,String xlsheet,int rownum)
	 * throws IOException { fi=new FileInputStream(xlfile); wb=new XSSFWorkbook(fi);
	 * ws=wb.getSheet(xlsheet); row=ws.getRow(rownum); int
	 * cellcount=row.getLastCellNum(); wb.close(); fi.close(); return cellcount; }
	 */
	public static String getCellData(String file1, String sheet, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(file1);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;
		try {
//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of
													// the cell type.
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;

	}

	/*
	 * public static String getCellData(String xlfile,String xlsheet,int rownum,int
	 * colnum) throws IOException { fi=new FileInputStream(xlfile); wb=new
	 * XSSFWorkbook(fi); ws=wb.getSheet(xlsheet); row=ws.getRow(rownum);
	 * cell=row.getCell(colnum);
	 * 
	 * String data; try { //data=cell.toString(); DataFormatter formatter = new
	 * DataFormatter(); data = formatter.formatCellValue(cell); //Returns the
	 * formatted value of a cell as a String regardless of the cell type. } catch
	 * (Exception e) { data=""; }
	 * 
	 * wb.close(); fi.close(); return data; }
	 */
//passing data into cell
	public static void setCellData(String file1, String sheet, int rownum, int cellnum, String data)
			throws IOException {
		fi = new FileInputStream(file1);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);

		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(file1);

		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	/*
	 * public static void setCellData(String xlfile,String xlsheet,int rownum,int
	 * colnum,String data) throws IOException { fi=new FileInputStream(xlfile);
	 * wb=new XSSFWorkbook(fi); ws=wb.getSheet(xlsheet); row=ws.getRow(rownum);
	 * 
	 * cell=row.createCell(colnum); cell.setCellValue(data); fo=new
	 * FileOutputStream(xlfile); wb.write(fo); wb.close(); fi.close(); fo.close();
	 */

	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
