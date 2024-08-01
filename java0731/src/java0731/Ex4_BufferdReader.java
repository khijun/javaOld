package java0731;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Ex4_BufferdReader {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("c:/Temp/file/data.txt");
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out::println);
		
		File file = path.toFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		stream = br.lines();
		stream.forEach(System.out::println);
	}
}
