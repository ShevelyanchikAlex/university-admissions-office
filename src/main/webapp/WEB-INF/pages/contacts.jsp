<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="contacts.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/contactsStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<section class="header-text">
    <div class="text-box">
        <h1><fmt:message key="contacts.contact_us"/></h1>
    </div>
</section>

<div class="contacts-row">
    <div class="contacts-container">
        <div class="contacts-data">
            <table>
                <tr>
                    <td class="faculty-value-name"><b><i class="fas fa-map-marker-alt"></i><fmt:message
                            key="contacts.address"/></b></td>
                    <td class="faculty-value"><fmt:message key="contacts.address.value"/></td>
                </tr>
                <tr>

                    <td class="faculty-value-name"><b><i class="fas fa-phone"></i><fmt:message
                            key="contacts.phone"/></b></td>
                    <td class="faculty-value"><fmt:message key="contacts.phone.value"/></td>
                </tr>
                <tr>
                    <td class="faculty-value-name"><b><i class="fas fa-envelope"></i><fmt:message key="contacts.email"/></b>
                    </td>
                    <td class="faculty-value"><fmt:message key="contacts.email.value"/></td>
                </tr>
            </table>

        </div>
    </div>
    <div class="campus-row">
        <img class="campus-image" src="${pageContext.request.contextPath}/assets/image/campus1.jpeg" alt="">
        <img class="campus-image" src="${pageContext.request.contextPath}/assets/image/campus2.png" alt="">
    </div>
</div>
<jsp:include page="general/footer.jsp"/>
</body>
</html>
