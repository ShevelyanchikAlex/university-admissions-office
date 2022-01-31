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
<div class="search">
    <div><i class="fas fa-search search-icon"></i></div>
    <div class="input"><input id="myInput" class="form-control" onkeyup='tableSearch()' placeholder="Search"
                              type="text"></div>
    <div class="select-column-number">
        <select name="select-column" id="selectedColumn">
            <option value="0" selected>ID</option>
            <option value="1">Email</option>
            <option value="2">Name</option>
            <option value="3">Surname</option>
            <option value="4">Passport data</option>
        </select>
    </div>
</div>

<table class="table" id="myTable" data-filter-control="true" data-show-search-clear-button="true">
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

<script>
    function tableSearch() {
        let input, filter, table, tr, td, txtValue;
        let selectedColumn;

        input = document.getElementById("myInput");
        selectedColumn = document.getElementById("selectedColumn");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
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
