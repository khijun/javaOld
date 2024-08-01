package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter2 {
	public static void main(String[] args) throws IOException {
		File dir = new File("c:/Temp/file");
		File file1 = new File("c:/Temp/file/data.txt");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		if(file1.exists() == false) {
			file1.createNewFile();
		}
		Writer writer = new FileWriter("c:/Temp/file/data.txt");
		String str = "안녕자바";
		writer.write(str);
		writer.flush();
		writer.close();
	}
}
