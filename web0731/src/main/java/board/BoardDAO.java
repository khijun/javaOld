package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class BoardDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String BOARD_LIST = "select * from board";
	private final String BOARD_WHERE_NUM = "select * from board where num = ?";
	private final String BOARD_INSERT = "insert into board(writer, title, content, regtime, hits) values(?,?,?,now(),0)";
	private final String BOARD_UPDATE = "update board set writer=?, title=?, content=? where num=?";
	private final String BOARD_DELETE = "delete from board where num=?";
	private final String BOARD_HITS_INCREMENT= "update board set hits = hits + 1 where num=?";
	
	public List<BoardDTO> getBoardList(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = getBoardRs(rs);
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	public BoardDTO getOne(int num) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_WHERE_NUM);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			rs.next();
			return getBoardRs(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return null;
	}
	
	public void increaseHits(int num) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_HITS_INCREMENT);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	public void insertBoard(BoardDTO dto) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	public void updateBoard(BoardDTO dto) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	public void deleteBoard(int num) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	
	private BoardDTO getBoardRs(ResultSet rs) throws SQLException{
		return new BoardDTO(rs.getInt("num"), 
				rs.getString("writer"), 
				rs.getString("title"), 
				rs.getString("content"), 
				rs.getString("regtime"), 
				rs.getInt("hits"));
	}
}
