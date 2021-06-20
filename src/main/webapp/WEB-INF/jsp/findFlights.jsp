<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Find Flights</title>
</head>

<body>
<h2>Find Flights: </h2>
<form action = "findFlights" method="post">

From: <input type="text" name="from" value = "AUS" required/>
To: <input type="text" name="to" value = "NYC" required/>
Departure Date: <input type="text" name="departureDate" value = "02-05-2018" required/>
<input type="submit" value="search"/>

</form>

</body>
</html>