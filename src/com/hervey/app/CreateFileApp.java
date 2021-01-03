package com.hervey.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
		
		String lineToWrite = "abe does a job";
		
//		lineToWrite = returnLineFromConsole();
//		
//		writeLine(bufferedWriter, lineToWrite);
		

		int maxIteration = 5;	
		int counter = 0;
		while(true) {
		counter++;
		lineToWrite = returnLineFromConsole();
		
		writeLine(bufferedWriter, lineToWrite);			
		System.out.println("lineToWrite>>"+lineToWrite+"<<<");
			if(lineToWrite.equals("exit")  || counter >= maxIteration) {
				System.out.println("time to break out of here");
				break;
			}
			
		}
		
		
		bufferedWriter.close() ;

	}



	private static String returnLineFromConsole() throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		Reader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("Type Line for file entry");
		String lineForFile = bufferedReader.readLine();
		
		return lineForFile ;
	}



	private static void writeLine(BufferedWriter bufferedWriter, String lineToWrite) throws IOException {
		bufferedWriter.newLine();
		bufferedWriter.write(lineToWrite);
		System.out.println(" we wrote newLine then " + lineToWrite);
	}



	private static BufferedWriter fetchBufferedWriterObject(String inFileName) {
		FileWriter writerFile;
		BufferedWriter createdWriter = null;
		try {
			writerFile = new FileWriter(inFileName);
			createdWriter = new BufferedWriter(writerFile);
			System.out.println("created or recreated writeFile");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return createdWriter;
	}

	static String fetchFileName() throws IOException {
		// during prototyping, file name is given as literal
		// later will be collected from console
		String fileName = "example.txt";
		
		InputStream inputStream = System.in;
		Reader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("Type name of file to record your lines");
		fileName = bufferedReader.readLine();
	
		System.out.println("fileName is:  " + fileName);
		return fileName;
	}

}
