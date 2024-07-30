<%@page import="java.beans.Visibility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 데이터베이스 접속
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
//임시 저장 변수들
int maxPage = 10;
String idTmp = "";
String nameTmp = "";
String ssnTmp = "";
String telTmp = "";
String balanceTmp = "";
String sqlTmp = "";
String deposit = request.getParameter("deposit");
String withdraw = request.getParameter("withdraw");
// 매개변수들
request.setCharacterEncoding("UTF-8");        // 한글 처리
String find = request.getParameter("find");   // update하기 전 학번을 클릭하면 넘어오는 매개변수값
String id = request.getParameter("id");     // null이면 insert나 update를 하지 말아야
String name = request.getParameter("name");
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String balance = request.getParameter("balance");
String delete = request.getParameter("delete");
String value = request.getParameter("value");
String selection = request.getParameter("selection"); 

int showingPageAmount = 5;
String currPage = request.getParameter("currPage")==null?"1":request.getParameter("currPage");

if (delete != null) {
	sqlTmp = "delete from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, delete);
	int ret = pstmt.executeUpdate();
}

// update하기 전 학번을 클릭하면
if (find != null) {
	sqlTmp = "select * from account where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		nameTmp = rs.getString("name");
		ssnTmp = rs.getString("ssn");
		telTmp = rs.getString("tel");
		balanceTmp = rs.getString("balance");
	}
}

// 학번이 null이 아니면 이미 입력된 학번인지 조회
if (id != null) {
	sqlTmp = "select count(*) from account where id = ?";  // 이미 있는 학번 조회 (있으면 1을 가져옴)
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int cnt = rs.getInt(1);  // 0: insert, 1: update
	if (cnt == 1) { // 정보 수정
		sqlTmp = "update account set name = ?, ssn = ?, tel = ? where num = ?";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setString(4, id);
		int ret = pstmt.executeUpdate();
	} else if(!id.equals("")){ //정보 입력
		sqlTmp = "insert into account(name, ssn, tel, balance) values (?,?,?,?)";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setInt(4, 0);
		System.out.println(String.format("%s, %s, %s, %s", name, ssn, tel, balance));
		int ret = pstmt.executeUpdate();
	}
}

if(withdraw!=null&&!("".equals(withdraw))){
	sqlTmp = "update account set balance = balance - ? where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, value);
	pstmt.setString(2, withdraw);
	pstmt.executeUpdate();
} else if(deposit!=null&&!("".equals(deposit))){
	sqlTmp = "update account set balance = balance + ? where id = ?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, value);
	pstmt.setString(2, deposit);
	pstmt.executeUpdate();
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        table { width: 600px; text-align: left; }
        th    { width: 40px; background-color: cyan; }
    </style>
<title>Account</title>
</head>
<body>
<form>
<%
if("".equals(selection)||selection==null){ %>
	아이디&emsp;: <input type="text" name="id" value="<%=idTmp %>"><br>
	이름&emsp;&emsp;: <input type="text" name="name" value="<%=nameTmp %>"><br>
    주민번호: <input type="text" name="ssn" value="<%=ssnTmp%>"><br>
    전화번호: <input type="text" name="tel" value="<%=telTmp %>"><br>
    예금액&emsp;: <input type="text" name="balance" value="<%=balanceTmp %>"><br>
    <input type="submit" value="입력/수정"></form>
    <button  onclick="location.href='?selection=deposit'" >예금</button>
    <button  onclick="location.href='?selection=withdraw'" >출금</button>
<%
} else if("deposit".equals(selection)) { System.out.println("true");%>
	아이디&emsp;: <input type="text" name="deposit" value=""><br>
    예금액&emsp;: <input type="text" name="value" value=""><br>
    <input type = "submit" value="예금"></form>
<%
} else if("withdraw".equals(selection)) { System.out.println("true");%>
	아이디&emsp;: <input type="text" name="withdraw" value=""><br>
    출금액&emsp;: <input type="text" name="value" value=""><br>
    <input type = "submit" value="예금"></form>
<%} %>
<table border = "1">
<tr>
        <th>아이디</th><th>이름</th>
        <th>생년월일</th><th>전화번호</th><th>예금액</th>
        <th>삭제</th>
</tr>

<%
sqlTmp = "select count(*) from account";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

rs.next();
int result = rs.getInt(1);
maxPage = result%showingPageAmount==0?(result/showingPageAmount):(result/showingPageAmount)+1;
	
sqlTmp = "select * from account limit ?,?";
pstmt = conn.prepareStatement(sqlTmp);
pstmt.setInt(1, 1 + (Integer.parseInt(currPage)-1)*showingPageAmount);
pstmt.setInt(2, showingPageAmount);
rs = pstmt.executeQuery();

while(rs.next()) {
	idTmp= rs.getString("id");
	nameTmp = rs.getString("name");
	ssnTmp = rs.getString("ssn");
	telTmp = rs.getString("tel");
	balanceTmp = rs.getString("balance");
%>	
	<tr>
	<td><a href="?find=<%=idTmp %>"><%=idTmp %></a></td><td><%=nameTmp %></td><td><%=ssnTmp %></td>
	<td><%=telTmp %></td><td><%=balanceTmp %></td>
	<td><button  onclick="location.href='?delete=<%=idTmp%>'" >삭제</button></td>
	</tr>
<%
}
%>
</table><p/>

<table>
<tr>
<%
for(int i = Integer.parseInt(currPage) - 2; i <= Integer.parseInt(currPage) + 2; i++){
	%><td><%
	if(i>0&&i<=maxPage){
		%><button  onclick="location.href='?currPage=<%=i%>'" ><%=i %></button><%
	}else{
		%><button disabled="disabled"></button><%
	}
	%></td><%
}
%>
</tr>
</table>
</body>
</html>