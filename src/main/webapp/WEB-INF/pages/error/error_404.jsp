<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="error.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/errorStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<div class="container">
    <img class="image-error" src="${pageContext.request.contextPath}/assets/image/error.png" alt=""/>
    <h2 class="error-header"><fmt:message key="error.404.header"/></h2>
    <h1 class="error-message"><fmt:message key="error.404.message"/></h1>
</div>
</body>
</html>
