<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Complete Reservation</title>
</head>

<body>
<h2>Complete Reservation: </h2>
Airlines: ${flight.operatingAirlines}
<br>
Departure City: ${flight.departureCity}
<br>
Arrival City: ${flight.arrivalCity}

<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details:</h2>
First Name:<input type="text" name="passengerFirstName" required/>
Last Name:<input type="text" name="passengerLastName" required/>
Email:<input type="text" name="passengerEmail" required/>
Note: Enter Genuine Email ID to get confirmation mail which will showcase email functionality.
    Else, you are good to enter fake Email ID.

Phone:<input type="text" name="passengerPhone" required/>

<h2>Card Details:</h2>
Name on the Card:<input type="text" name="nameOnTheCard" value = "James" required/>
Card No:<input type="text" name="cardNumber" value="9898989898" required/>
Expiry Date:<input type="text" name="expirationDate" value = "17/09/2023" required/>
CVV:<input type="text" name="securityCode" value = "123" required/>

<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit" value="confirm"/>
</pre>
</form>

</body>
</html>