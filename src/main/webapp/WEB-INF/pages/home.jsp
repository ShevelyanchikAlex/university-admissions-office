<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="home.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/homeStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<section class="header-text">
    <div class="text-box">
        <h1><fmt:message key="home.university.name"/></h1>
        <p><fmt:message key="home.university.short_description_first_part"/><br><fmt:message
                key="home.university.short_description_second_part"/></p>
        <a href="#" class="hero-button"><fmt:message key="home.university.visit_us_button"/></a>
    </div>
</section>


<div class="faculties">
    <h1><fmt:message key="home.university.faculties.title"/></h1>
    <p><fmt:message key="home.university.faculties.short_description"/></p>

    <div class="faculties-row">
        <div class="faculty-col">
            <h3><fmt:message key="faculties.EECS.full_name"/></h3>
            <p><fmt:message key="faculties.EECS.short_description"/></p>
        </div>
        <div class="faculty-col">
            <h3><fmt:message key="faculties.MECHE.full_name"/></h3>
            <p><fmt:message key="faculties.MECHE.short_description"/></p>
        </div>
        <div class="faculty-col">
            <h3><fmt:message key="faculties.DSS.full_name"/></h3>
            <p><fmt:message key="faculties.DSS.short_description"/></p>
        </div>
    </div>
</div>
</body>
<jsp:include page="general/footer.jsp"/>
</html>
