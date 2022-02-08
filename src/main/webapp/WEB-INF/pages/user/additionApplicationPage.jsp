<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="addition_application.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/additionApplicationStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<c:if test="${sessionScope.input_hint_status == 'SHOW'}">
    <div class="input-hint-block">
        <h1 class="input-hint-header"><fmt:message key="addition_application.input_hint.title"/></h1>
        <p class="input-hint-message"><fmt:message key="addition_application.input_hint.message"/></p>
    </div>
</c:if>
<div class="container">
    <form action="controller" class="form" method="post">
        <input type="hidden" name="command" value="add_application">
        <h1>
            <fmt:message key="addition_application.title"/>
        </h1>
        <label class="prev-text">
            <fmt:message key="addition_application.choosing_faculty"/>
        </label>
        <select name="selected_faculty_id" class="box">
            <option value="<fmt:message key="faculties.EECS.id"/>" selected><fmt:message
                    key="faculties.EECS.short_name"/></option>
            <option value="<fmt:message key="faculties.MECHE.id"/>"><fmt:message
                    key="faculties.MECHE.short_name"/></option>
            <option value="<fmt:message key="faculties.DSS.id"/>"><fmt:message
                    key="faculties.DSS.short_name"/></option>
        </select>
        <label class="prev-text">
            <fmt:message key="addition_application.points_first_subject"/>
        </label>
        <input type="number" name="points_first_subject" class="box"
               placeholder="<fmt:message key="addition_application.points_first_subject_placeholder"/>" min="0"
               max="100" required/>
        <label class="prev-text">
            <fmt:message key="addition_application.points_second_subject"/>
        </label>
        <input type="number" name="points_second_subject" class="box"
               placeholder="<fmt:message key="addition_application.points_second_subject_placeholder"/>" min="0"
               max="100" required/>
        <label class="prev-text">
            <fmt:message key="addition_application.points_third_subject"/>
        </label>
        <input type="number" name="points_third_subject" class="box"
               placeholder="<fmt:message key="addition_application.points_third_subject_placeholder"/>" min="0"
               max="100" required/>

        <div class="input-hint-row">
            <div class="column-input-hint-bottom">
                <a href="<c:url value="/controller?command=change_input_hint_status" />" class="show-input-hint-button">
                    <c:if test="${sessionScope.input_hint_status == null || sessionScope.input_hint_status == 'HIDE'}">
                        <fmt:message key="addition_application.input_hint.show_input_hint_button"/>
                    </c:if>
                    <c:if test="${sessionScope.input_hint_status == 'SHOW'}">
                        <fmt:message key="addition_application.input_hint.hide_input_hint_button"/>
                    </c:if>
                </a>
            </div>
        </div>
        <input type="submit" value="<fmt:message key="addition_application.create_button"/>" id="submit"/>
    </form>
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/add_application.png"
             alt="">
    </div>
</div>
</body>
<jsp:include page="../general/footer.jsp"/>
</html>