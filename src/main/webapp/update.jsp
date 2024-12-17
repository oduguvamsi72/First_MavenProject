<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
<form action="update" method="post">
		<input type="password" name="password" placeholder="Current Password"><br>
		<input type="password" name="newpassword" placeholder="New Password"><br>
		<input type="password" name="confirmnewpassword" placeholder="Confirm New Password"><br>
		<button type="submit">Update Password</button>
	</form>
</body>
</html>