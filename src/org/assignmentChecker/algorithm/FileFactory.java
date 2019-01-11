package org.assignmentChecker.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.assignmentchecker.manupulation_of_path.PathString;

public class FileFactory implements PathString {

	private FileFactory() {
		try {
			file = new File(out);
			if (file.exists()) {
				file.delete();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new FileWriter(file);
			buffer = new BufferedWriter(writer);
			reader = new FileReader(in);
			buffered = new BufferedReader(reader);
			scanner = new Scanner(buffered);
		} catch (IOException e) {

			System.out.println("FileFactory Construction Exception : " + e.getMessage());
		}
	}

	public static BufferedReader bufferedRader() {
		return instance.buffered;
	}

	public static Scanner scanner() {
		return instance.scanner;
	}

	public static BufferedWriter writer() {
		return instance.buffer;
	}

	public static void close() {
		try {
			instance.reader.close();
			instance.buffered.close();
			instance.scanner.close();
			instance.buffer.close();
			instance.reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Is Not Closed");
		}
	}

	private static FileFactory instance = new FileFactory();
	private FileReader reader;
	private BufferedReader buffered;
	private Scanner scanner;
	private BufferedWriter buffer;
	private FileWriter writer;
	private File file;
}