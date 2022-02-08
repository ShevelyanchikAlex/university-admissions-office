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
    <div class="input"><input id="search-input" class="form-control" onkeyup='tableSearch()'
                              placeholder="<fmt:message key="admin.statistic.search.placeholder"/>"
                              type="text"></div>
    <div class="select-column-number">
        <select name="select-column" id="selectedColumn">
            <option value="0" selected><fmt:message key="admin.statistic.applications_table.application_id"/></option>
            <option value="1" selected><fmt:message key="admin.statistic.applications_table.user_id"/></option>
            <option value="2"><fmt:message key="admin.statistic.applications_table.faculty"/></option>
        </select>
    </div>
</div>

<table class="table" id="applications-table" data-filter-control="true" data-show-search-clear-button="true">
    <thead>
    <tr>
        <th><fmt:message key="admin.statistic.applications_table.application_id"/></th>
        <th><fmt:message key="admin.statistic.applications_table.user_id"/></th>
        <th><fmt:message key="admin.statistic.applications_table.faculty"/></th>
        <%--        <th><fmt:message key="admin.statistic.applications_table.score"/></th>--%>
        <th><fmt:message key="admin.statistic.applications_table.application_date"/></th>
        <th><fmt:message key="admin.statistic.applications_table.confirm"/></th>
        <th><fmt:message key="admin.statistic.applications_table.reject"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.not_responded_applications}" var="application">
    <tr>
        <td>${application.applicationId}</td>
        <td>${application.userId}</td>
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
        <td><a class="confirm-button"
               href="<c:url value="/controller?command=confirm_application" />&application_id=${application.applicationId}"><fmt:message
                key="admin.statistic.applications_table.confirm"/></a>
        </td>
        <td><a class="reject-button"
               href="<c:url value="/controller?command=go_to_reject_application_page" />&application_id=${application.applicationId}"><fmt:message
                key="admin.statistic.applications_table.reject"/></a>
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

        input = document.getElementById("search-input");
        selectedColumn = document.getElementById("selectedColumn");
        filter = input.value.toUpperCase();
        table = document.getElementById("applications-table");
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
