/**
 * 
 */
package org.assignmentchecker.master;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.assignmentchecker.manupulation_of_path.Path;

/**
 * @author Saif_sust_2013331007
 *
 */
public class ScannerMaster {

	/**
	 * @param args
	 */
	protected static void close() {
		try {
			Freader.close();
			Breader.close();
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Scanner scanCode(String path) {
		try {
			Freader = new FileReader(path);
			Breader = new BufferedReader(Freader);
			scanner = new Scanner(Breader);
		} catch (FileNotFoundException e) {
			System.out.println("ScannerMaster scanCode Exception : " + e.getMessage());
		}

		return scanner;
	}

	public static void main(String[] args) {

		File f = RegNumReaderMaster.RegNum("dataStore").get(0);
		File s = SolutionReaderMaster.solutions(Path.getPath(f)).get(0);
		String str = scanCode(Path.getPath(s)).nextLine();
		System.out.println(str);
		close();

	}

	private static FileReader Freader;
	private static BufferedReader Breader;
	private static Scanner scanner;
}
