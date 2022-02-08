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
            <option value="0" selected><fmt:message
                    key="admin.statistic.responded_applications_table.application_id"/></option>
            <option value="1"><fmt:message key="admin.statistic.responded_applications_table.faculty"/></option>
        </select>
    </div>
</div>

<table class="table" id="responded-applications-table" data-filter-control="true" data-show-search-clear-button="true">
    <thead>
    <tr>
        <th><fmt:message key="admin.statistic.responded_applications_table.application_id"/></th>
        <th><fmt:message key="admin.statistic.responded_applications_table.faculty"/></th>
        <th><fmt:message key="admin.statistic.responded_applications_table.application_date"/></th>
        <th><fmt:message key="admin.statistic.responded_applications_table.confirmation_date"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.responded_applications}" var="application">
        <tr>
            <td>${application.applicationId}</td>
            <td>
                <c:choose>
                    <c:when test="${application.facultyId == 1}">
                        <p><fmt:message key="admin.statistic.eecs"/></p>
                    </c:when>
                    <c:when test="${application.facultyId == 2}">
                        <p><fmt:message key="admin.statistic.meche"/></p>
                    </c:when>
                    <c:when test="${application.facultyId == 3}">
                        <p><fmt:message key="admin.statistic.dss"/></p>
                    </c:when>
                </c:choose>
            </td>
            <td>${application.applyDate}</td>
            <td>${application.decisionDate}</td>
        </tr>
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
        table = document.getElementById("responded-applications-table");
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