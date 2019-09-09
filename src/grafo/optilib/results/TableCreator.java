package grafo.optilib.results;

import grafo.optilib.results.Result.ResultInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TableCreator {

	public static void createTable(String outputFile, List<Result> results) {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet s = wb.createSheet("DATA");
		// ROW FOR HEADINGS
		XSSFRow row = s.createRow(0);
		XSSFCell cell;
		int columnIdx = 0;
		cell = row.createCell(columnIdx);
		cell.setCellValue("Instance");
		columnIdx++;
		for (ResultInfo info : results.get(0).getResults()) {
			cell = row.createCell(columnIdx);
			cell.setCellValue(info.getName());
			columnIdx++;
		}
		int rowIdx = 1;
		for (Result r : results) {
			XSSFRow rowData = s.createRow(rowIdx);
			XSSFCell cellData = rowData.createCell(0);
			cellData.setCellValue(r.getInstanceName());
			columnIdx = 1;
			for (ResultInfo info : r.getResults()) {
				cellData = rowData.createCell(columnIdx);
				cellData.setCellValue(info.getValue());
				columnIdx++;
			}
			rowIdx++;
		}
		try {
			wb.write(new FileOutputStream(outputFile));
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
