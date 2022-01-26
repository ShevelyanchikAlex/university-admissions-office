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
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.applicants}" var="applicant">
    <tr>
        <td>${applicant.userId}</td>
        <td>${applicant.email}</td>
        <td>${applicant.name}</td>
        <td>${applicant.surname}</td>
        <td>${applicant.passportId}</td>
        <td><a class="response-button"
               href="<c:url value="/controller?command=delete_applicant" />&user_id=${applicant.userId}">Delete</a>
        </td>
    <tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
