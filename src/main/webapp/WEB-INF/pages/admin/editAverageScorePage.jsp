<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="admin.edit_average_score_page.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/editAverageScoreStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<c:if test="${sessionScope.input_hint_status == 'SHOW'}">
    <div class="input-hint-block">
        <h1 class="input-hint-header"><fmt:message key="faculties.input_hint.title"/></h1>
        <p class="input-hint-message"><fmt:message key="faculties.input_hint.message"/></p>
    </div>
</c:if>
<div class="container">
    <form action="controller" class="form" method="post">
        <input type="hidden" name="command" value="edit_average_score">
        <input type="hidden" name="selected_faculty_id" value="${requestScope.selected_faculty_id}">
        <h1><fmt:message key="admin.edit_average_score_page.title"/></h1>
        <label class="prev-text">
            <fmt:message key="admin.edit_average_score_page.average_score_of"/>
            <c:choose>
                <c:when test="${requestScope.selected_faculty_id == 1}">
                    <fmt:message key="faculties_page.eecs"/>
                </c:when>
                <c:when test="${requestScope.selected_faculty_id == 2}">
                    <fmt:message key="faculties_page.meche"/>
                </c:when>
                <c:when test="${requestScope.selected_faculty_id == 3}">
                    <fmt:message key="faculties_page.dss"/>
                </c:when>
            </c:choose>
        </label>
        <input type="number" name="selected_faculty_score" class="box"
               placeholder="<fmt:message key="admin.edit_average_score_page.input_placeholder"/>"
               value="${requestScope.selected_faculty_score}" min="0" max="300" required/>

        <div class="input-hint-row">
            <div class="column-input-hint-bottom">
                <a href="<c:url value="/controller?command=change_input_hint_status" />"
                   class="show-input-hint-button">
                    <c:if test="${sessionScope.input_hint_status == null || sessionScope.input_hint_status == 'HIDE'}">
                        <fmt:message key="faculties.input_hint.show_input_hint_button"/>
                    </c:if>
                    <c:if test="${sessionScope.input_hint_status == 'SHOW'}">
                        <fmt:message key="faculties.input_hint.hide_input_hint_button"/>
                    </c:if>
                </a>
            </div>
        </div>
        <input type="submit" value="<fmt:message key="admin.edit_average_score_page.save_button"/>" id="submit"/>
    </form>
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/admin.png" alt="">
    </div>
</div>
</body>
<jsp:include page="../general/footer.jsp"/>
</html>
