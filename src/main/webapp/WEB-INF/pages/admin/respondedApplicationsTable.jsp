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
        <th>Passport data</th>
        <th>Faculty</th>
        <th>First subject's points</th>
        <th>Second subject's points</th>
        <th>Third subject's points</th>
        <th>Application date</th>
        <th>Confirmation date</th>
        <th>Reason for rejection</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>AV1231122</td>
        <td>KSIS</td>
        <td>70</td>
        <td>90</td>
        <td>80</td>
        <td>22.04.2022</td>
        <td>27.04.2022</td>
        <td>-</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Edit</a>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>AV1231122</td>
        <td>KSIS</td>
        <td>70</td>
        <td>90</td>
        <td>80</td>
        <td>22.04.2022</td>
        <td>27.04.2022</td>
        <td>-</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Edit</a>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>AV1231122</td>
        <td>KSIS</td>
        <td>70</td>
        <td>90</td>
        <td>80</td>
        <td>22.04.2022</td>
        <td>27.04.2022</td>
        <td>-</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Edit</a>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td>shevelyanchik@mail.ru</td>
        <td>AV1231122</td>
        <td>KSIS</td>
        <td>70</td>
        <td>90</td>
        <td>80</td>
        <td>22.04.2022</td>
        <td>27.04.2022</td>
        <td>Some data hbfdhd</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Edit</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
