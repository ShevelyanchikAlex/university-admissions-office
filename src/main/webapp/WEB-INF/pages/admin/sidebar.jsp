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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/sidebarStyle.css">
</head>
<body>
<div class="sidebar">
    <a href="<c:url value="/controller?command=get_statistics" />">
        <i class="far fa-chart-bar"></i>
        <h3><fmt:message key="admin.sidebar.statistics"/></h3>
    </a>
    <a href="<c:url value="/controller?command=get_applications_table" />">
        <i class="fas fa-poll"></i>
        <h3><fmt:message key="admin.sidebar.applications"/></h3>
    </a>
    <a href="<c:url value="/controller?command=get_responded_applications_table" />">
        <i class="fas fa-clipboard-check"></i>
        <h3><fmt:message key="admin.sidebar.responded_applications"/></h3>
    </a>
    <a href="<c:url value="/controller?command=get_administrators_table" />">
        <i class="fas fa-users"></i>
        <h3><fmt:message key="admin.sidebar.administrators"/></h3>
    </a>
    <a href="<c:url value="/controller?command=get_applicants_table" />">
        <i class="fas fa-user-graduate"></i>
        <h3><fmt:message key="admin.sidebar.applicants"/></h3>
    </a>
</div>
</body>
</html>
