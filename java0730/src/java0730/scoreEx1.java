package java0730;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class scoreEx1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		List<Score> list = new ArrayList<Score>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "mysql");
			String sql = "select * from score";
			pstmt = con.prepareStatement(sql);
			System.out.println("test");
			rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				Score s = new Score(rs.getInt("num"),rs.getString("name")
						,rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
				list.add(s);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		List<Integer> scoreList = new ArrayList<>();
		list.stream().forEach(s->{
			System.out.println(String.format("[%s] 총점: %d, 평균: %.2f",s.getName(), s.getTotal(), s.getAvg()));
		});
		
		
		OptionalDouble korAvg = list.stream().mapToInt(s->s.getKor()).average();
		System.out.println(list.stream().mapToInt(s->s.getKor()).sum());
		System.out.println(list.stream().mapToInt(s->s.getEng()).sum());
		System.out.println(list.stream().mapToInt(s->s.getMath()).sum());
		System.out.println(korAvg);
	}
}
