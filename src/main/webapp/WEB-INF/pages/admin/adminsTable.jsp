<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/tableStyle.css">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Passport data</th>
        <th>Send email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.administrators}" var="admin">
    <tr>
        <td>${admin.userId}</td>
        <td>${admin.email}</td>
        <td>${admin.name}</td>
        <td>${admin.surname}</td>
        <td>${admin.passportId}</td>
        <td><a class="response-button"
               href="#">Send email</a>
        </td>
    <tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
