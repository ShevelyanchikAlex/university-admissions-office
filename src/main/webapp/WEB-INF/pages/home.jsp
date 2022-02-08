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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/homeStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<section class="header-text">
    <div class="text-box">
        <h1><fmt:message key="home.university.name"/></h1>
        <p><fmt:message key="home.university.short_description_first_part"/><br>
            <fmt:message key="home.university.short_description_second_part"/></p>
        <a href="<c:url value="/controller?command=go_to_contacts_page" />" class="hero-button"><fmt:message
                key="home.university.visit_us.button"/></a>
    </div>
</section>

<hr class="line-separator-header">

<div class="benefits">
    <h1><fmt:message key="home.university.benefits.title"/></h1>

    <div class="benefits-row">
        <div class="benefits-tile">
            <div class="benefits-data">
                <i class="fas fa-user-graduate"></i>
                <table>
                    <div class="benefits-col">
                        <h3><fmt:message key="home.university.benefits.best_students"/></h3>
                    </div>
                </table>
            </div>
        </div>
        <div class="benefits-tile">
            <div class="benefits-data">
                <i class="fas fa-chalkboard-teacher"></i>
                <table>
                    <div class="benefits-col">
                        <h3><fmt:message key="home.university.benefits.best_teachers"/></h3>
                    </div>
                </table>
            </div>
        </div>
        <div class="benefits-tile">
            <div class="benefits-data">
                <i class="fas fa-graduation-cap"></i>
                <table>
                    <div class="benefits-col">
                        <h3><fmt:message key="home.university.benefits.best_education"/></h3>
                    </div>
                </table>
            </div>
        </div>
        <div class="benefits-tile">
            <div class="benefits-data">
                <i class="fas fa-users"></i>
                <table>
                    <div class="benefits-col">
                        <h3><fmt:message key="home.university.benefits.best_networking"/></h3>
                    </div>
                </table>
            </div>
        </div>
    </div>

</div>

<hr class="line-separator">

<div class="faculties">
    <h1><fmt:message key="home.university.faculties.title"/></h1>
    <p><fmt:message key="home.university.faculties.short_description"/></p>

    <div class="faculty-row">
        <div class="faculty-score-tile">
            <div class="faculty-data">
                <img class="faculty-logo" src="${pageContext.request.contextPath}/assets/image/eecs_logo.png">
                <table>
                    <div class="faculty-col">
                        <h4><fmt:message key="home.university.faculties.eecs"/></h4>
                    </div>
                </table>
            </div>
        </div>
        <div class="faculty-score-tile">
            <div class="faculty-data">
                <img class="faculty-logo" src="${pageContext.request.contextPath}/assets/image/meche_logo.png">
                <table>
                    <div class="faculty-col">
                        <h4><fmt:message key="home.university.faculties.meche"/></h4>
                    </div>
                </table>
            </div>
        </div>
        <div class="faculty-score-tile">
            <div class="faculty-data">
                <img class="faculty-logo" src="${pageContext.request.contextPath}/assets/image/dss_logo.png">
                <table>
                    <div class="faculty-col">
                        <h4><fmt:message key="home.university.faculties.dss"/></h4>
                    </div>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="general/footer.jsp"/>
</html>