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
        <th>Faculty</th>
        <th>First subject's points</th>
        <th>Second subject's points</th>
        <th>Third subject's points</th>
        <th>Application date</th>
        <th>Response</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>3</td>
        <td>shevelyanchik@mail.ru</td>
        <td>Alex</td>
        <td>Shevelyanchik</td>
        <td>DSS</td>
        <td>90</td>
        <td>80</td>
        <td>85</td>
        <td>22.01.2022</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Response</a>
        </td>
    </tr>
    <tr>
        <td>5</td>
        <td>shipa@gmail.com</td>
        <td>Pasha</td>
        <td>Qvashonkin</td>
        <td>DSS</td>
        <td>90</td>
        <td>77</td>
        <td>85</td>
        <td>22.01.2022</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Response</a>
        </td>
    </tr>
    <tr>
        <td>6</td>
        <td>kirik@gmail.com</td>
        <td>Kirill</td>
        <td>Petrov</td>
        <td>EECS</td>
        <td>90</td>
        <td>77</td>
        <td>85</td>
        <td>22.01.2022</td>
        <td><a class="response-button"
               href="?${RequestParameter.COMMAND}=${CommandName.GOTO_EDIT_PERSONAL_DATA_PAGE_COMMAND}">Response</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
