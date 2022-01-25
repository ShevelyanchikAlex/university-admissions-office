<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footerStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <title></title>

<footer>
    <div class="footer-container">
        <div class="footer-sec about">
            <h2><fmt:message key="footer.about_us"/></h2>
            <p><fmt:message key="footer.about_us.text"/></p>
        </div>
        <div class="footer-sec links">
            <h2><fmt:message key="footer.quick_links"/></h2>
            <ul class="footer-nav-links">
                <li><a href="#"><fmt:message key="footer.quick_links.about"/></a></li>
                <li><a href="#"><fmt:message key="footer.quick_links.contacts"/></a></li>
                <li><a href="#"><fmt:message key="footer.quick_links.help"/></a></li>
            </ul>
        </div>
        <div class="footer-sec links">
            <h2><fmt:message key="footer.university"/></h2>
            <ul class="footer-nav-links">
                <li><a href="#"><fmt:message key="footer.quick_links.help.history_of_university"/></a></li>
                <li><a href="#"><fmt:message key="footer.quick_links.help.achievements"/></a></li>
                <li><a href="#"><fmt:message key="footer.quick_links.help.faculties"/></a></li>
                <li><a href="#"><fmt:message key="footer.quick_links.help.admissions_office"/></a></li>
            </ul>
        </div>
        <div class="footer-sec contact">
            <h2><fmt:message key="footer.contact_us"/></h2>
            <ul class="footer-info">
                <li>
                    <span><i class="fa fa-map-marked" aria-hidden="true"></i></span>
                    <span><fmt:message key="footer.contact_us.address.street"/><br>
                    <fmt:message key="footer.contact_us.address.city"/>, <fmt:message
                                key="footer.contact_us.address.country"/></span>
                </li>
                <li>
                    <span><i class="fa fa-envelope" aria-hidden="true"></i></span>
                    <p><a href="#"><fmt:message key="footer.contact_us.email"/></a></p>
                </li>
            </ul>
        </div>
    </div>
</footer>
    <div class="footer-copyrightText">
        <p><fmt:message key="footer.copyright"/></p>
    </div>
</html>
