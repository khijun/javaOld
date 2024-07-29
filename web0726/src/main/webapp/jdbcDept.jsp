<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loc = request.getParameter("loc");
String str = "";
ResultSet rs = null;
int maxPage = 10;
int currPage = (str=request.getParameter("currPage"))==null||str.equals("")?0:Integer.parseInt(str);
int showTableCount = (str=request.getParameter("showTableCount"))==null||str.equals("")?1:Integer.parseInt(str);
Connection con = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3307/spring5fs";
con = DriverManager.getConnection(url, "root", "mysql");
pstmt = con.prepareStatement("select count(*) from dept");
rs = pstmt.executeQuery();
rs.next();
maxPage = rs.getInt(1)%showTableCount==0?rs.getInt(1)/showTableCount:rs.getInt(1)/showTableCount+1;

String sql = loc!=null&&!loc.equals("")?"select * from dept where loc = ? limit ?,?":
	"select * from dept limit ?,?";
//pstmt.setString(1, "서울");
pstmt = con.prepareStatement(sql);
int i = 0;
if(loc != null && !loc.equals(""))pstmt.setString(1, loc);
else i++;
pstmt.setInt(2-i, currPage*showTableCount);
pstmt.setInt(3-i, showTableCount);
rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
지역: <input type = "text" name = "loc">
<input type = "submit">
</form>
<p>
<table border = "1">
<%
while(rs.next()){
	%>
	<tr>
	<td><%=rs.getInt("deptno")%></td>
	<td><%=rs.getString("dname")%></td>
	<td><%=rs.getString("loc")%></td>
	</tr><%
}
%>
</table>
<select name = "showTableCount">
<option value = "1">1</option>
<% for(int j = currPage-1; j <= currPage+3; j++){ if(j > 0 && j <= maxPage){%>
</select>
<a href = "http://localhost:8080/web0726/jdbcDept.jsp?currPage=<%=j-1%>&showTableCount=<%=showTableCount%>">
<input type = "submit" value = <%=j %>></a>
<%}} %>
</body>
</html>