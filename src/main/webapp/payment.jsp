<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Page</title>
</head>
<body>
<form action="payment" method="post">
        <label for="">cardholdername:</label>
        <input type="text" name="cardholdername" placeholder="Vamsi Odugu"><br>
        <label for="">cardnumber:</label>
        <input type="text" name="cardnumber" placeholder="1234 5678 9012 3456"><br>
        <label for="">Expirydate:</label>
        <input type="month" name="expirydate" placeholder="MM/YY"><br>
        <label for="">cvv:</label>
        <input type="password" name="cvv" placeholder="123"><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>