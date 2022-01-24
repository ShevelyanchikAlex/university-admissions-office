<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="signup.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headerStyle.css">
</head>
<body>

<section class="upper-header">
    <div class="change-locale-block">
        <form class="change-locale-button" action="${pageContext.request.contextPath}/controller?command=change_locale"
              method="post">
            <input type="hidden" name="locale" value="en"/>
            <img src="${pageContext.request.contextPath}/assets/image/united-kingdom.png" class="locale-image" alt="">
            <input class="change-locale-text" type="submit" value="Eng"/>
        </form>
        <form class="change-locale-button" action="${pageContext.request.contextPath}/controller?command=change_locale"
              method="post">
            <input type="hidden" name="locale" value="ru"/>
            <img src="${pageContext.request.contextPath}/assets/image/russia.png" class="locale-image" alt="">
            <input class="change-locale-text" type="submit" value="Рус"/>
        </form>
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
            <label class="university-name"><fmt:message key="header.university_name"/><a
                    href="<c:url value="/controller?command=go_to_home_page" />"></a></label>
        </div>
        <ul class="nav-links">
            <li><a class="link" href="<c:url value="/controller?command=go_to_home_page" />"><fmt:message
                    key="header.links.home"/></a></li>
            <li><a class="link" href="<c:url value="/controller?command=go_to_home_page" />"><fmt:message
                    key="header.links.about"/></a></li>
            <li><a class="link" href="<c:url value="/controller?command=go_to_home_page" />"><fmt:message
                    key="header.links.faculties"/></a></li>
            <li><a class="link" href="<c:url value="/controller?command=go_to_contacts_page" />"><fmt:message
                    key="header.links.contacts"/></a></li>
            <c:if test="${sessionScope.user_id == null}">
                    <li class="log-in-btn"><a href="<c:url value="/controller?command=go_to_log_in_page" />">
                        <fmt:message key="header.log_in_button"/>
                    </a></li>
                    <li class="sign-up-btn"><a class="sign-up-text"
                                               href="<c:url value="/controller?command=go_to_sign_up_page" />">
                        <fmt:message key="header.sign_up_button"/>
                    </a></li>
            </c:if>
            <c:if test="${sessionScope.user_id != null}">
                <li><a class="link" href="<c:url value="/controller?command=go_to_profile_page" />">
                    <fmt:message key="header.links.profile"/></a></li>
                <li class="log-out-btn"><a class="log-out-text"
                                           href="<c:url value="/controller?command=logout" />">
                    <fmt:message key="header.log_out_button"/>
                </a></li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>
