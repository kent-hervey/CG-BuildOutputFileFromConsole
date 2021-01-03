package com.hervey.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
•	Read the file name from the console.
•	Create and use a BufferedWriter object.
•	Do not read anything from the file system.
•	Read lines from the console until the user enters "exit".
•	Write absolutely all of the entered lines (including "exit") to the file, each on a new line.
•	The main method should close the BufferedWriter object after using it

*/

public class CreateFileApp {

	public static void main(String[] args) throws IOException{

		String fileName = fetchFileName();

		// create BufferedWriter object

		BufferedWriter bufferedWriter = fetchBufferedWriterObject(fileName);
		
		bufferedWriter.close() ;

	}

	private static BufferedWriter fetchBufferedWriterObject(String inFileName) {
		FileWriter writerFile;
		BufferedWriter createdWriter = null;
		try {
			writerFile = new FileWriter(inFileName);
			createdWriter = new BufferedWriter(writerFile);
			System.out.println("created writeFile");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return createdWriter;
	}

	static String fetchFileName() {
		// during prototyping, file name is given as literal
		// later will be collected from console
		String fileName = "example.txt";
		System.out.println("fileName is:  " + fileName);
		return fileName;
	}

}
