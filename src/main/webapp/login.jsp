<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>username</th>
				<th>email</th>
				<th>password</th>
			</tr>
		</thead>
		<tbody>
			<%
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "root");
				String sql = "select * from register";
				PreparedStatement pmst = conn.prepareStatement(sql);
				ResultSet rs = pmst.executeQuery();
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("username")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("password")%></td>
			</tr>
			<%
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</tbody>
	</table>
</body>
</html>