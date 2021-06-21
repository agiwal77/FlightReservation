<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Find Flights</title>
</head>

<body>
<h2>Find Flights: </h2>
<form action = "findFlights" method="post">
<datalist id="city">
    <option value="BOM">Mumbai, BOM</option>
    <option value="DEL">Delhi, DEL</option>
    <option value="PNQ">Pune, PNQ</option>
    <option value="BLR">Bengaluru, BLR</option>
    <option value="HYD">Hyderabad, HYD</option>
</datalist>

From: <input type="text" name="from" value = "BLR" list = "city" required/>
To: <input type="text" name="to" value = "DEL" list = "city" required/>
Departure Date: <input type="text" name="departureDate" placeholder="mm-dd-yyyy" required/>
<input type="submit" value="search"/>

</form>

</body>
</html>