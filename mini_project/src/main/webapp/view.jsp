<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String t=(String)session.getAttribute("title");
String url="jdbc:mysql://localhost:3306/mini_project";
String un="root";
String pw="root";
String query="select * from  admin where title=?";
response.setContentType("text/html");
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,pw,un);
	PreparedStatement st = con.prepareStatement(query);
	st.setString(1,t);
	ResultSet r = st.executeQuery();
while(r.next()) {
	out.print(r.getString(1));
	out.print(r.getString(2));
	out.print(r.getObject(3));
	out.print(r.getString(4));
}
}
catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}
%>
</body>
</html>