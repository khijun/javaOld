package board;

public class Ex2 {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(0, "글쓴이", "제목", "내영", "", 0);
		dao.insertBoard(dto);
	}
}
