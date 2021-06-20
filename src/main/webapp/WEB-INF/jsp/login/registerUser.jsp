<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Register User</title>
</head>

<body>
<h2>User Registration: </h2>
<form action = "registerUser" method="post">
<pre>
First Name: <input type="text" name="firstName" required/>
Last Name: <input type="text" name="lastName" required/>
User Name: <input type="text" name="email" required/>
Password: <input type="password" name="password" required/>
Confirm Password: <input type="password" name="confirmPassword" required/>
<input type="submit" value="register"/>
</pre>
</form>

</body>
</html>