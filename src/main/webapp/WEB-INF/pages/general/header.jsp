<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="locale"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="signup.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerStyle.css">
</head>
<body>

<section class="upper-header">
    <div class="change-locale-block">
        <a href="#" class="change-locale-text"><i class="fas fa-globe change-locale-icon"></i><fmt:message
                key="header.change_locale"/></a>
    </div>
    <div class="social-block">
        <div class="social-btn">
            <a href="#"><i class="fas fa-envelope"></i></a>
            <a href="#"><i class="fab fa-facebook"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-vk"></i></a>
        </div>
    </div>
</section>
<div class="header">
    <nav>
        <div class="university-logo-name">
            <img class="university-image" src="${pageContext.request.contextPath}/assets/image/university_logo.png"
                 alt="">
            <label class="university-name"><fmt:message key="header.university_name"/></label>
        </div>
        <ul class="nav-links">
            <li><a href=""><fmt:message key="header.links.home"/></a></li>
            <li><a href=""><fmt:message key="header.links.about"/></a></li>
            <li><a href=""><fmt:message key="header.links.faculties"/></a></li>
            <li><a href=""><fmt:message key="header.links.contacts"/></a></li>
            <li class="log-in-btn"><fmt:message key="header.log_in_button"/></li>
            <li class="sign-up-btn"><fmt:message key="header.sign_up_button"/></li>
        </ul>
    </nav>
</div>
</body>
</html>