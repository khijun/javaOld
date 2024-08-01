<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String username = null;
Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("username")){
			username = cookies[i].getValue();
			break;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My JSP Homepage</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        nav {
            background-color: #444;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        nav a {
            color: #fff;
            margin: 0 10px;
            text-decoration: none;
        }
        .content {
            padding: 20px;
            text-align: center;
        }
        .content img {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to My JSP Homepage</h1>
    </header>
    <nav>
        <a href="#">Home</a>
        <a href="#">About</a>
		<%
			if(username==null){
			%><a href="login.jsp">Login</a><%
			}else{
			%>
			<a><%=username %></a>
			<a href="logout.jsp">Logout</a><%
			}
		%>
    </nav>
    <div class="content">
        <h2>Hello, World!</h2>
        <p>This is a sample JSP homepage. You can add more content here.</p>
        <img src="images/sample.jpg" alt="Sample Image">
    </div>
</body>
</html>