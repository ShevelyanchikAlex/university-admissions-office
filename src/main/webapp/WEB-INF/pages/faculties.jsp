<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="faculties_page.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/facultiesStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<div class="page-title">
    <h1><fmt:message key="faculties_page.our_faculties"/></h1>
</div>

<section class="faculty-tile">
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/eecs_logo.png" alt="">
    </div>
    <div class="text-box">
        <h3><fmt:message key="faculties_page.eecs_faculty"/></h3>
    </div>
</section>

<hr class="line-separator">

<section class="faculty-tile">
    <div class="text-box">
        <h3><fmt:message key="faculties_page.meche_faculty"/></h3>
    </div>
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/meche_logo.png" alt="">
    </div>
</section>

<hr class="line-separator">

<section class="faculty-tile">
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/dss_logo.png" alt="">
    </div>
    <div class="text-box">
        <h3><fmt:message key="faculties_page.dss_faculty"/></h3>
    </div>
</section>

<hr class="line-separator">


<div class="faculty-average-score-title">
    <h2><fmt:message key="faculties_page.passing_score_faculties"/></h2>
</div>

<div class="faculty-score-row" id="faculty-score-row-id">

    <c:forEach var="faculty_admission_info" items="${sessionScope.faculties_admission_info_list}">
        <div class="faculty-score-container">
            <div class="faculty-data">
                <div class="icon">
                    <i class="fas fa-graduation-cap"></i>
                </div>
                <table>
                    <tr>
                        <td class="faculty-value-name"><b><fmt:message key="faculties_page.faculty_title"/></b></td>
                        <c:choose>
                            <c:when test="${faculty_admission_info.facultyId == 1}">
                                <td class="faculty-value"><fmt:message key="faculties_page.eecs"/></td>
                            </c:when>
                            <c:when test="${faculty_admission_info.facultyId == 2}">
                                <td class="faculty-value"><fmt:message key="faculties_page.meche"/></td>
                            </c:when>
                            <c:when test="${faculty_admission_info.facultyId == 3}">
                                <td class="faculty-value"><fmt:message key="faculties_page.dss"/></td>
                            </c:when>
                        </c:choose>
                    </tr>
                    <tr>
                        <td class="faculty-value-name"><b><fmt:message key="faculties_page.passing_score"/></b></td>
                        <td class="faculty-value">${faculty_admission_info.passingScore}</td>
                    </tr>
                </table>
            </div>
        </div>
    </c:forEach>

</div>
<jsp:include page="general/footer.jsp"/>
</body>
</html>
