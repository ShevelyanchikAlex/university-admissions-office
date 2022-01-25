<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="profile.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/adminStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<div class="admin-container">
    <jsp:include page="sidebar.jsp"/>
    <c:if test="${sessionScope.admin_table == 'APPLICATIONS_TABLE' || sessionScope.admin_table == null}">
        <jsp:include page="applicationsTable.jsp"/>
    </c:if>
    <c:if test="${sessionScope.admin_table == 'RESPONDED_APPLICATIONS_TABLE'}">
        <jsp:include page="respondedApplicationsTable.jsp"/>
    </c:if>
    <c:if test="${sessionScope.admin_table == 'APPLICANTS_TABLE'}">
        <jsp:include page="applicantsTable.jsp"/>
    </c:if>
    <c:if test="${sessionScope.admin_table == 'ADMINISTRATORS_TABLE'}">
        <jsp:include page="adminsTable.jsp"/>
    </c:if>
</div>
</body>
<jsp:include page="../general/footer.jsp"/>
</html>
