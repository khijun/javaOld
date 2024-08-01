package drive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import board.BoardDAO;
import board.BoardDTO;

public class ReadEx {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("c:/Temp/boardUTF-8.csv"));
		String line = null;
		BoardDAO dao = new BoardDAO();
		while((line = br.readLine()) != null) {
			String[] data = line.split(", ");
			
			BoardDTO dto = new BoardDTO(0, data[0], data[1], data[2], "", 0);
			System.out.println(dto);
//			dao.insertBoard(dto);
		}
		br.close();
	}
}
