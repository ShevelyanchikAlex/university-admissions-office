<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="about.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/aboutStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<div class="page-title">
    <h1><fmt:message key="about.header_page.title"/></h1>
</div>

<section class="header-text">
    <div class="text-box">
        <h2><fmt:message key="about.short_description_university"/></h2>
    </div>
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/university_logo.png" alt="">
    </div>
</section>

<hr class="line-separator">

<div class="mission-title">
    <h1><fmt:message key="about.mission_of_university.title"/></h1>
</div>

<section class="mission-text">
    <div class="mission-text-box">
        <h3><fmt:message key="about.mission_of_university.description_first"/></h3>
        <h3><fmt:message key="about.mission_of_university.description_second"/></h3>
    </div>
</section>
<jsp:include page="general/footer.jsp"/>
</body>
</html>
