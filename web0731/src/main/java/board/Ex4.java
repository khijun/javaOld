package board;

public class Ex4 {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(new BoardDTO(15, "업데이트 테스트", "ㅌㅅㅌ", "ㅌㅅㅌ", "", 0));
		dao.deleteBoard(15);
	}
}
