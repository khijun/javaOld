package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import util.JDBCUtil;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//로그인
	public MemberDTO login(MemberDTO iDto) {
		MemberDTO dto = null;
		List<MemberDTO> list = selectAllMember();
		for(MemberDTO memberDTO : list) {
			if(memberDTO.getId().equals(iDto.getId())&&memberDTO.getPw().equals(iDto.getPw())) {
				dto = memberDTO;
			}
		}
		return dto;
	}
//	public void addLoginToSession(MemberDTO dto) {
//		HttpSession session = request.get
//	}
	final static String SELECT_ALL = "select * from member";
	public List<MemberDTO> selectAllMember(){
		List<MemberDTO> list = new ArrayList<>();
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name")));
			}
		} catch (SQLException e) {
			System.out.println("SelectAllMember Failed");
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return list;
	}
	//가입
	final static String INSERT_MEMBER = "insert into member values(?,?,?)";
	public void joinMember(MemberDTO dto) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(INSERT_MEMBER);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			if(pstmt.executeUpdate()!=1) throw new SQLException();
		}catch(SQLException e) {
			System.out.println("JoinMember Failed");
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	//현재 로그인한 사용자 정보 읽기
	final static String SELECT_ONE = "select * from member where id = ?";
	public MemberDTO getMemberInfo(MemberDTO dto) {
		con = JDBCUtil.getConnection();
		MemberDTO rsDto = null;
		try {
			pstmt = con.prepareStatement(SELECT_ONE);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			rs.next();
			rsDto = new MemberDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name"));
		}catch(SQLException e) {
			System.out.println("GetMemberInfo Failed");
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return rsDto;
	}
	
	public boolean isExist(MemberDTO dto) {
		return getMemberInfo(dto) != null?true:false;
	}
	
	//회원정보 수정
	final static String UPDATE_MEMBER = "update member set pw = ?, name = ? where id = ?";
	public void updateMember(MemberDTO dto, MemberDTO newDto) {
		try {
			if(!isExist(dto)) {throw new SQLException();}
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(UPDATE_MEMBER);
			pstmt.setString(1, newDto.getPw());
			pstmt.setString(2, newDto.getName());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("UpdateMember Failed");
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
}
