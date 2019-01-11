package org.assignmentchecker.excelwriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assignmentchecker.models.StudentData;

public class ExcelWriter {

	private static File excelFile;
	private static FileOutputStream outStream;
	private static XSSFWorkbook workbook;
	private static XSSFSheet excelSheet;

	public static void writer(List<StudentData> information, String PATH) {

		try {
			excelFile = new File(PATH);
			if (!excelFile.exists()) {
				excelFile.createNewFile();
			}

			outStream = new FileOutputStream(excelFile);

			workbook = new XSSFWorkbook();

			excelSheet = workbook.createSheet("STUDENT COPY PASTE INFORMATION");

			Row currRow = excelSheet.createRow(0);
			Cell currCell = currRow.createCell(0);
			currCell.setCellValue("Registration No.");

			currCell = currRow.createCell(1);
			currCell.setCellValue("Marks");

			currCell = currRow.createCell(2);
			currCell.setCellValue("Copy");

			currCell = currRow.createCell(3);
			currCell.setCellValue("Solves");

			for (int rownum = 1; rownum <= information.size(); ++rownum) {

				currRow = excelSheet.createRow(rownum);
				currCell = currRow.createCell(0);
				StudentData data = information.get(rownum - 1).getAll();
				currCell.setCellValue(data.getRegNum());
				currCell = currRow.createCell(1);
				currCell.setCellValue(data.getMarks());
				currCell = currRow.createCell(2);
				currCell.setCellValue(data.getCopy());
				currCell = currRow.createCell(3);
				currCell.setCellValue(data.getSolved());

			}

			workbook.write(outStream);
			outStream.flush();
			outStream.close();

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("EXCEL WRITE EXCEPTION : " + ex.getMessage());
		}

		System.out.println("SUCCESSFULLY WRITE");

	}

}
