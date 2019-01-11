/**
 * 
 */
package org.assignmentchecker.master;

import java.util.regex.Pattern;

/**
 * @author Saif_sust_2013331007
 *
 */
public class IgnorMaster {

	/**
	 * @param args
	 */
	// int a=1 /* */
	/*
	 *
	 */
	/*
	 * //*
	 */

	public static String ignorSlashComment(String line) {
		return line.split(Pattern.quote("//"))[0];
	}

	public static String ignorStarComment(String line) {
		String str = "", arr[], array[];
		if (line.contains("/*") && line.contains("*/")) {
			arr = line.split(Pattern.quote("/*"));
			array = line.split(Pattern.quote("*/"));
			if (arr.length > 0 && array.length > 1) {
				return arr[0] + " " + array[1];
			} else {
				if (arr.length > 0) {
					return arr[0];
				} else {
					if (array.length > 1) {
						return array[1];
					} else
						return "";
				}
			}
		} else {
			if (line.contains("/*")) {
				arr = line.split(Pattern.quote("/*"));
				if (arr.length > 0) {
					return arr[0];
				} else
					return "";
			} else {
				if (line.contains("*/")) {
					arr = line.split(Pattern.quote("*/"));
					if (arr.length > 1) {
						return arr[1];
					} else
						return "";
				}
			}
		}
		return line;
	}

	public static boolean ignorHeader(String line) {
		String[] header = { "import", "#include", "package" };
		for (int i = 0; i < header.length; i++) {
			if (line.contains(header[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		 System.out.println(IgnorMaster.ignorSlashComment("int a=30;//int a=23;int u=8658;"));
		//System.out.println(ignorMaster.ignorStarComment("aa"));

		// System.out.println(ignorMaster.ignorHeader("packag"));
	}

}
