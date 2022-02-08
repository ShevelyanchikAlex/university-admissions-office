<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/tableStyle.css">
</head>
<body>
<div class="search">
    <div><i class="fas fa-search search-icon"></i></div>
    <div class="input"><input id="search-input" class="form-control" onkeyup='tableSearch()'
                              placeholder="<fmt:message key="admin.statistic.search.placeholder"/>"
                              type="text"></div>
    <div class="select-column-number">
        <select name="select-column" id="selectedColumn">
            <option value="0" selected><fmt:message key="admin.statistic.users.id"/></option>
            <option value="1"><fmt:message key="admin.statistic.users.email"/></option>
            <option value="2"><fmt:message key="admin.statistic.users.name"/></option>
            <option value="3"><fmt:message key="admin.statistic.users.surname"/></option>
            <option value="4"><fmt:message key="admin.statistic.users.passport_data"/></option>
        </select>
    </div>
</div>

<table class="table" id="admins-table" data-filter-control="true" data-show-search-clear-button="true">
    <thead>
    <tr>
        <th><fmt:message key="admin.statistic.users.id"/></th>
        <th><fmt:message key="admin.statistic.users.email"/></th>
        <th><fmt:message key="admin.statistic.users.name"/></th>
        <th><fmt:message key="admin.statistic.users.surname"/></th>
        <th><fmt:message key="admin.statistic.users.passport_data"/></th>
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
    <tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>

<script>
    function tableSearch() {
        let input, filter, table, tr, td, txtValue;
        let selectedColumn;

        input = document.getElementById("search-input");
        selectedColumn = document.getElementById("selectedColumn");
        filter = input.value.toUpperCase();
        table = document.getElementById("admins-table");
        tr = table.getElementsByTagName("tr");

        for (let i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[selectedColumn.value];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
