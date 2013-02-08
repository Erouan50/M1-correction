<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: erouan
  Date: 2/7/13
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add customer order</title>
</head>
<body>
<h1>Add customer order</h1>

<form action="${pageContext.servletContext.contextPath}/addCustomerOrder" method="POST">
    <label for="firstName">First name: </label>
    <input type="text" id="firstName" name="firstName"/>
    <br/>
    <label for="lastName">Last name: </label>
    <input type="text" id="lastName" name="lastName"/>
    <br/>
    <label for="email">Email: </label>
    <input type="text" id="email" name="email"/>
    <br/>
    <label for="idTrip">Trip: </label>
    <select id="idTrip" name="idTrip">
        <c:forEach items="${trips}" var="trip">
            <option value="${trip.id}">${trip.departureStation.name} - ${trip.arrivalStation.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Ok"/>
</form>
</body>
</html>