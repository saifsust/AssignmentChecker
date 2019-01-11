/**
 * 
 */
package org.assignmentchecker.master;

import java.io.*;
import java.lang.*;
import java.util.*;

import org.assignmentchecker.manupulation_of_path.Path;

/**
 * @author Saif_sust_2013331007
 *
 */
public class RegNumReaderMaster {

	/**
	 * 
	 * @param args
	 */
	protected static void clear() {
		RegNumList.clear();
	}

	protected static List<File> RegNum(String path) {
		RegNumList = new ArrayList<File>();
		file = new File(path);
		folderArray = file.listFiles();
		RegNumList.clear();
		for (int i = 0; i < folderArray.length; i++) {
			if (folderArray[i].isDirectory()) {
				RegNumList.add(folderArray[i]);
			}
		}
		return RegNumList;
	}

	public static void main(String[] args) {

		RegNumList = RegNum("dataStore");
		for (int i = 0; i < RegNumList.size(); i++) {
			System.out.println(Path.getPath(RegNumList.get(i)));
		}

	}

	private static File file;
	private static File[] folderArray;
	private static List<File> RegNumList;
}
