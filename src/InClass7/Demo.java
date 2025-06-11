package InClass7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo {

    //	File, FileReader, FileWriter, BufferedReader, BufferedWriter, PrintWriter
    public static void main(String[] args) throws IOException {
//		File file = new File("D:/New-Workspace/Demo/text.txt");
//		boolean isCreated = file.createNewFile();
//		System.out.println(isCreated);

//		boolean isDeleted = file.delete();
//		System.out.println(isDeleted);

//		boolean isDirectory = file.isDirectory();
//		System.out.println(isDirectory);
//
//		System.out.println(file.getAbsolutePath());

//		System.out.println(file.length());

//		File[] arr = file.listFiles();
//		System.out.println(arr.length);


//		==========FileReader=========

//		FileReader fileReader = new FileReader("D:/New-Workspace/Demo/text.txt");
//		int ch; // ASCII
//		while ((ch = fileReader.read()) != -1) {
//			System.out.print((char)ch);
//		}
//		fileReader.close();


        // try-with-resources
//		try (FileReader fileReader = new FileReader("D:/New-Workspace/Demo/text.txt")) {
//			int ch; // ASCII
//			while ((ch = fileReader.read()) != -1) {
//				System.out.print((char) ch);
//			}
//		}

//		==========FileWriter=========

//		FileWriter fileWriter = new FileWriter("D:/New-Workspace/Demo/text.txt", true);
//		fileWriter.write("Hi this is testing.");
//		fileWriter.close();

//		===========BufferedReader=========
//		BufferedReader br = new BufferedReader(new FileReader("D:/New-Workspace/Demo/text.txt"));
//		String line;
//		while((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
//		br.close();

//		===========BufferedWriter=========
//		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/New-Workspace/Demo/text.txt", true));
//		bw.newLine();
//		bw.write("This is printed by BufferedWriter");
//		bw.close();

//		==============PrintWriter=========
        PrintWriter pw = new PrintWriter(new FileWriter("text.txt"), true);
        pw.println("This is printed by println");
        pw.printf("Formatted Num: %.2f", 12.45458);
        pw.close();
    }
}
