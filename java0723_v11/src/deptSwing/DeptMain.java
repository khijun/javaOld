package deptSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeptMain {
	
	
	//create table, drop table, insert, select
	//콘솔창에서 입력받아 dept 테이블에 insert 하는 자바 프로그램 만들기
	//스윙으로 dept, emp 테이블 출력하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		String sql = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean run = true;
		while(run) {
			showMain();
			int menuNum = 0;
			
			menuNum = Integer.parseInt(sc.nextLine());
			switch(menuNum) {
			case 1:	// 테이블 생성
				sql = "CREATE TABLE IF NOT EXISTS `dept` (" +	// dept 테이블 생성
						  "`DEPTNO` int(11) DEFAULT NULL," +
						  "`DNAME` varchar(14) DEFAULT NULL," +
						  "`LOC` varchar(13) DEFAULT NULL" +
						") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
				try {
					System.out.println("dept 테이블 생성");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("dept 테이블 생성 실패");
				}
				
				sql = "CREATE TABLE IF NOT EXISTS `emp` ("+	// emp 테이블 생성
						  "`EMPNO` int(11) NOT NULL,"+
						  "`ENAME` varchar(10) DEFAULT NULL,"+
						  "`JOB` varchar(9) DEFAULT NULL,"+
						  "`MGR` int(11) DEFAULT NULL,"+
						  "`HIREDATE` date DEFAULT NULL,"+
						  "`SAL` int(11) DEFAULT NULL,"+
						  "`COMM` int(11) DEFAULT NULL,"+
						  "`DEPTNO` int(11) DEFAULT NULL"+
						") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
				try {
					System.out.println("emp 테이블 생성");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("emp	 테이블 생성 실패");
				}
				break;
			case 2:
				sql = "INSERT INTO `dept` (`DEPTNO`, `DNAME`, `LOC`) VALUES"	// dept 데이터 삽입
				+ "(10, 'ACCOUNTING', 'NEW YORK'),"
				+ "(20, 'RESEARCH', 'DALLAS'),"
				+ "(30, 'SALES', 'CHICAGO'),"
				+ "(40, 'OPERATIONS', 'BOSTON');";
				try {
					System.out.println("dept 데이터 삽입");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("dept 데이터 삽입 실패");
				}
		
				// emp 데이터 삽입
				sql = "INSERT INTO `emp` (`EMPNO`, `ENAME`, `JOB`, `MGR`, `HIREDATE`, `SAL`, `COMM`, `DEPTNO`) VALUES"
						+ "(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20),"
						+ "(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30),"
						+ "(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30),"
						+ "(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20),"
						+ "(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),"
						+ "(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30),"
						+ "(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10),"
						+ "(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000, NULL, 20),"
						+ "(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10),"
						+ "(7844, 'TURNER', 'SALESMAN', 7698, '1980-09-08', 1500, 0, 30),"
						+ "(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1100, NULL, 20),"
						+ "(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30),"
						+ "(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20),"
						+ "(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10);";
				try {
					System.out.println("emp 데이터 삽입");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("emp	데이터 삽입 실패");
				}
				break;
			case 3:	// 데이터 삭제
				sql = "delete from dept";
				try {
					System.out.println("dept 데이터 삭제");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("dept 데이터 삭제 실패");
				}
				sql = "delete from emp";
				try {
					System.out.println("emp 데이터삭제");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("emp 데이터 삭제 실패");
				}
				break;
			case 4:	// 테이블삭제
				sql = "drop table dept";
				try {
					System.out.println("dept 테이블 삭제");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("dept 테이블 삭제 실패");
				}
				sql = "drop table emp";
				try {
					System.out.println("emp 테이블 삭제");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("emp 테이블 삭제 실패");
				}
				break;
			case 5:
				System.out.print("deptno 입력");
				int deptno = Integer.parseInt(sc.nextLine());
				System.out.print("dname 입력");
				String dname = sc.nextLine();
				System.out.print("loc 입력");
				String loc = sc.nextLine();
				sql = "insert into dept values(" + deptno + "," + dname + "," + loc + ")";
				// pstmt = "insert into dept vales(?,?,?)"
				try {
					System.out.println("dept에 데이터 삽입");
					pstmt = con.prepareStatement(sql);
					int num = pstmt.executeUpdate();
					System.out.println("수정한 행의 개수: " + num);
				}catch(SQLException e) {
					System.out.println("dept에 데이터 삽입 실패");
				}
				break;
			case 6:
				sql = "select * from dept";
				try {
					System.out.println("dept 출력");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getInt(1) + ", " + 
						rs.getString(2) + ", " + rs.getString(3));
					}
				}catch(SQLException e) {
					System.out.println("dept 출력 실패");
				}
				break;
			case 7:
				sql = "select * from emp";
				try {
					System.out.println("emp 출력");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getInt(1) + ", " + 
						rs.getString(2) + ", " + rs.getString(3) +
						", " + rs.getInt(4) + ", " + rs.getString(5) +
						", " + rs.getInt(6) + ", " + rs.getInt(7)+
						", " + rs.getInt(8));
					}
				}catch(SQLException e) {
					System.out.println("emp 출력 실패");
				}
				break;
			case 8:
				run = false;
				break;
			}
		}
		System.out.println("시스템 종료");
		
	}
	
	public static void showMain() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("1.테이블 생성 | 2.테이블 데이터 삽입 | 3.테이블 데이터 전체삭제| 4.테이블 삭제");
		System.out.println("5.dept에 데이터 삽입| 6.dept테이블 데이터 출력 | 7.dept테이블 데이터 출력 | 8.종료");
		System.out.println("-------------------------------------------------------------------");
	}
}
