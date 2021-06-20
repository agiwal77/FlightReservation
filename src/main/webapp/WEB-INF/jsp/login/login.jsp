<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>

<body>
<h2>User Login: </h2>
<form action = "login" method="post">
<pre>
User Name: <input type="text" name="email" required/>
Password: <input type="password" name="password" required/>
<input type="submit" value="login"/>
</pre>
</form>
${error}
</body>
</html>