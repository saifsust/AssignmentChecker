/**
 * 
 */
package org.assignmentchecker.master;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.assignmentChecker.algorithm.StringToWords;

/**
 * @author Saif_sust_2013331007
 *
 */
public class ReaderMaster {

	private ReaderMaster() {
		codeList = new ArrayList<String>();
		backUpList = new ArrayList<String>();
	}

	/**
	 * @param args
	 *
	 */

	private boolean comment(String line) {
		if (line.length() > 2)
			return line.charAt(0) == '/' && line.charAt(1) == '/';
		else
			return false;
	}

	/*
	 * k/ /* jksdasgjd
	 */
	private static boolean starComment(String line) {
		if (line.length() > 2) {
			String str = line.substring(2, line.length());
			return line.charAt(0) == '/' && line.charAt(1) == '*' && str.contains("*/");
		}
		return false;
	}

	private static void StringToWord(String line, List<String> list) {
		line = StringToWords.StringToWord(line);
		StringTokenizer token = new StringTokenizer(line);
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
		}

	}

	/*
	 * /* fdhfghdgf
	 *
	 */
	private void Reader(String path) {
		codeList.clear();
		backUpList.clear();
		scanner = ScannerMaster.scanCode(path);
		String backUp;
		Continue = true;
		while (scanner.hasNextLine()) {
			backUp = "";
			line = scanner.nextLine();
			backUp = line;
			if (line.contains("/*") && line.contains("*/") && Continue) {
				line = IgnorMaster.ignorStarComment(line);
				if (!line.equals("")) {
					StringToWord(line, codeList);
					 //codeList.add(line);
				}
				continue;
			}
			if (line.equals("") || IgnorMaster.ignorHeader(line) || comment(line) || starComment(line))
				continue;

			if (line.contains("/*") && !line.contains("*/") && Continue) {
				line = IgnorMaster.ignorStarComment(line);
				Continue = false;
				if (line.equals("")) {
					continue;
				} else {
					StringToWord(line, codeList);
					StringToWord(line, backUpList);
					// backUpList.add(line);
					 //codeList.add(line);
					continue;
				}

			} else {

				if (line.contains("*/") && !Continue) {
					line = IgnorMaster.ignorStarComment(line);
					backUpList.clear();
					Continue = true;
				}

			}

			if (!Continue) {
				backUp = IgnorMaster.ignorSlashComment(backUp);
				backUp = IgnorMaster.ignorStarComment(backUp);
				if (!backUp.equals("")) {
					StringToWord(line, backUpList);
					// backUpList.add(backUp);
				}

				continue;
			}

			if (line.equals("")) {
				continue;
			} else {

				line = IgnorMaster.ignorSlashComment(line);
				line = IgnorMaster.ignorStarComment(line);

				if (line.equals("")) {
					continue;
				}
				StringToWord(line, codeList);
				 //codeList.add(line);
			}

		}
		//scanner.close();
		//scannerMaster.close();
	}

	public static List<String> getCode(String path) {
		instance.Reader(path);
		if (!instance.Continue) {
			for (int i = 0; i < instance.backUpList.size(); i++) {
				instance.codeList.add(instance.backUpList.get(i));
			}
		}
		return instance.codeList;
	}

	public static void clear() {
		instance.backUpList.clear();
		instance.codeList.clear();
	}

/*	public static void main(String[] args) {

		List<String> codeList = getCode("K:/Tutorials/src/assignmentCheckerAlgorithm/input.txt");
		for (int i = 0; i < codeList.size(); i++) {
			System.out.println(codeList.get(i));
		}

	}*/

	private boolean Continue = true;
	private String line, strLine[], strBackUp[];
	private static ReaderMaster instance = new ReaderMaster();
	private List<String> codeList, backUpList;
	private Scanner scanner;
}
