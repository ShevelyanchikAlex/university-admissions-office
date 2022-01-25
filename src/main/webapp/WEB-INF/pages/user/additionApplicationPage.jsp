<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="addition_application.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/additionApplicationStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<c:if test="${sessionScope.error != null}">
    <div class="alert-block">
        <label class="alert-message"><p class="alert-header"><fmt:message key="signup.alert_header"/></p>
                ${sessionScope.error}
        </label>
            ${sessionScope.remove("error")}
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
        <select name="select-faculty" class="box">
            <option value="value1" selected>KSIS</option>
            <option value="value2">IDS</option>
            <option value="value3">MNG</option>
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