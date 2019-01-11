/**
 * 
 */
package org.assignmentchecker.manupulation_of_path;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Path {

	/**
	 * @param args
	 */

	public static String getPath(File Name) {
		String path = Name.getAbsolutePath();
		return path.replace("\\", "/");
	}

	public static void main(String[] args) {
		String str = "\\";
		System.out.println(str);
	}

}
