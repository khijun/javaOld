package characterStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadEx {
	public static void main(String[] args) throws IOException{
		Reader reader = new FileReader("c:/Temp/test7.txt");
		String line = null;
		
		BufferedReader br = new BufferedReader(reader);
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println();
	
//		while(true) {
//			int data = reader.read();
//			if(data == -1) break;
//			System.out.println((char)data);;
//		}
		reader.close();
	}
}
