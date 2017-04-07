/**
 * 
 */
package assignmentCheckerAlgorithm;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Saif_sust_2013331007
 *
 */
public class StringToWords {

	/**
	 * @param args
	 */
	private static boolean Isoperator(char ch) {
		switch (ch) {
		case '+':
		case '-':
		case '%':
		case '/':
		case '!':
		case '=':
		case '&':
		case '^':
		case '|':
		case '*':
		case '~':
			return true;
		default:
			return false;
		}
	}

	protected static String StringToWord(String line) {
		String Line = "";
		for (int i = 0; i < line.length(); i++) {
			if (Character.isAlphabetic(line.charAt(i))) {
				Line += line.charAt(i);
			} else {
				if (Character.isDigit(line.charAt(i))) {
					int j, k;
					String Num = "";
					for (j = i, k = 0; j < line.length(); j++, k++) {
						if (Character.isDigit(line.charAt(j))) {
							Num += line.charAt(j);
						} else
							break;
					}
					i = j - 1;
					Line += " " + Num + " ";
					// System.out.println(Num);
				} else {
					if (Isoperator(line.charAt(i))) {
						Line += line.charAt(i);
					} else
						Line += " " + line.charAt(i) + " ";
				}
			}
		}
		return Line;
	}

	public static void main(String[] args) {

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			System.out.println(StringToWord(str));
		}
	}

	private static Scanner scanner = fileFactory.scanner();
}
