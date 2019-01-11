package org.assignmentchecker.excelwriter;

import java.util.ArrayList;
import java.util.List;

import org.assignmentchecker.models.StudentData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentData data = new StudentData("2013331007", 10.0, 89.0, 5);

		List<StudentData> infor = new ArrayList<StudentData>();

		for (int i = 0; i < 20; ++i) {
			infor.add(new StudentData("201333100" + i, 10.0 * i, 69.0, i));
		}

		ExcelWriter.writer(infor, "excel/out.xlsx");

	}

}
