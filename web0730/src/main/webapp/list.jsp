<%@page import="project0730.Board"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String url = "jdbc:mysql://localhost:3307/spring5fs";
Connection con = null;
ResultSet rs = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection(url, "root", "mysql");

String temp = request.getParameter("showingPageAmount");
String tempCurrPage = request.getParameter("currPage");
String tempMax = request.getParameter("dataCount");
System.out.println("2");
int currPage;
int showingPageAmount;
int dataCount;
int maxPage;
if(temp==null||"".equals(temp)){
	showingPageAmount = 10;
}else{
	showingPageAmount = Integer.parseInt(temp);
}
if(tempCurrPage==null||"".equals(tempCurrPage)){
	currPage = 1;
}else{
	currPage = Integer.parseInt(tempCurrPage);
}
if(tempMax==null||"".equals(tempMax)){
	tempMax = "select count(*) from board";
	pstmt = con.prepareStatement(tempMax);
	rs = pstmt.executeQuery();
	rs.next();
	dataCount = rs.getInt(1);
}else{
	dataCount = Integer.parseInt(tempMax);
}
	maxPage = dataCount/showingPageAmount;
	maxPage = dataCount%showingPageAmount==0?maxPage:maxPage + 1;


String sql = "select * from board limit ?,?";
pstmt = con.prepareStatement(sql);
pstmt.setInt(1, (currPage-1)*showingPageAmount);
pstmt.setInt(2, showingPageAmount);
rs = pstmt.executeQuery();	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>
<input type="button" value="5" onclick="location.href='list.jsp?showingPageAmount=5&dataCount=<%=dataCount%>'">
<input type="button" value="10" onclick="location.href='list.jsp?showingPageAmount=10&dataCount=<%=dataCount%>'">
<input type="button" value="20" onclick="location.href='list.jsp?showingPageAmount=20&dataCount=<%=dataCount%>'">
<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
while(rs.next()){
	Board board = new Board(rs.getString("num"), rs.getString("writer"),rs.getString("title"),new String("")/*rs.getString("context")*/,rs.getString("regtime"),rs.getString("hits"));
	%>
	<tr>
		<td><%=board.getNum() %></td>
		<td style="text-align:left;">
		 <a href="view.jsp?num=<%=board.getNum()%>"><%=board.getTitle() %></a></td>
		<td><%=board.getWriter() %></td>
		<td><%=board.getRegtime() %></td>
		<td><%=board.getHits() %></td>
	</tr>
<%
}
%>
</table>

<br>
<table>
<tr>
<td><input type="button" value="글쓰기" onclick="location.href='write.jsp'"></td>
<%
for(int i = currPage-2; i <= currPage+2; i++){ 
	if(i>0&&i<=maxPage){
%>
<td><button onclick="location.href='list.jsp?showingPageAmount=<%=showingPageAmount %>&currPage=<%=i%>&dataCount=<%=dataCount%>'"><%=i%></button></td>
<%
} else {
%>
<td><button disabled="disabled">　</button></td>
<%
} }
%>
</tr>
</table>

</body>
</html>