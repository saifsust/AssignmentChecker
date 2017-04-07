/**
 * 
 */
package assignmentCheckerAlgorithm;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class solutionReaderMaster {

	/**
	 * @param args
	 */

	protected static void clear() {
		solutionsList.clear();
	}

	protected static List<File> solutions(String path) {
		solutionsList = new ArrayList<File>();
		solutionsList.clear();
		file = new File(path);
		nameArray = file.listFiles();
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].isFile()) {
				solutionsList.add(nameArray[i]);
			}
		}
		return solutionsList;
	}

	public static void main(String[] args) {

		solutionsList = solutions("dataStore/2013331007");
		for (int i = 0; i < solutionsList.size(); i++) {
			System.out.println(Path.getPath(solutionsList.get(i)));
		}

	}

	private static File file, nameArray[];
	private static List<File> solutionsList;

}
