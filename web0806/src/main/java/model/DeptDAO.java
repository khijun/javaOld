package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class DeptDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String DEPT_LIST =  "select * from dept";
	
	public List<DeptDTO> getDeptList(){
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		
		con = JDBCUtil.getConnection();
		try {
			pstmt=con.prepareStatement(DEPT_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DeptDTO dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	final String DEPT_INSERT = "insert into dept values(?,?,?)";
	public void insertDept(DeptDTO dto) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(DEPT_INSERT);
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, con);
		}
	}
}
