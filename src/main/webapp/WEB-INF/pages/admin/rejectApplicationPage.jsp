<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="admin.reject_page.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/rejectFormStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<div class="container">
    <form action="controller" class="form" method="post">
        <input type="hidden" name="command" value="reject_application">
        <input type="hidden" name="application_id" value="${requestScope.application_id}">
        <h1><fmt:message key="admin.reject_page.header"/></h1>
        <label class="prev-text"><fmt:message key="admin.reject_page.reason_for_rejection"/></label>
        <textarea rows="10" type="text" name="rejection_reason" class="box"
                  placeholder="<fmt:message key="admin.reject_page.reason_for_rejection.placeholder"/>" maxlength="195" required></textarea>
        <input type="submit" value="<fmt:message key="admin.reject_page.reject_button"/>" id="submit"/>
    </form>
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/reject_reason.png" alt="">
    </div>
</div>
</body>
<jsp:include page="../general/footer.jsp"/>
</html>