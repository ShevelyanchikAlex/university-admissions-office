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
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>Alex</td>
        <td>Shevelyanchik</td>
        <td>AV1231122</td>
        <td><a class="send-email-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Send email</a>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>Alex</td>
        <td>Shevelyanchik</td>
        <td>AV1231122</td>
        <td><a class="send-email-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Send email</a>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>Alex</td>
        <td>Shevelyanchik</td>
        <td>AV1231122</td>
        <td><a class="send-email-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Send email</a>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>Alex</td>
        <td>Shevelyanchik</td>
        <td>AV1231122</td>
        <td><a class="send-email-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Send email</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
