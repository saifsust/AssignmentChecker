package assignmentCheckerAlgorithm;

import java.io.*;
import java.util.*;

class fileFactory implements pathString {

	private fileFactory() {
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
			e.printStackTrace();
			System.out.println("File Is Not Found");
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

	private static fileFactory instance = new fileFactory();
	private FileReader reader;
	private BufferedReader buffered;
	private Scanner scanner;
	private BufferedWriter buffer;
	private FileWriter writer;
	private File file;
}