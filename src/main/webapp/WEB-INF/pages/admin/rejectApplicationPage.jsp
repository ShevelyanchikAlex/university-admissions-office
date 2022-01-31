<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reject</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/rejectFormStyle.css">
</head>
<body>
<jsp:include page="../general/header.jsp"/>
<div class="container">
    <form action="controller" class="form" method="post">
        <input type="hidden" name="command" value="reject_application">
        <input type="hidden" name="application_id" value="${requestScope.application_id}">
        <h1>Rejection</h1>
        <label class="prev-text">Reason for Rejection</label>
        <textarea rows="10" type="text" name="rejection_reason" class="box"
                  placeholder="Enter Reason for Rejection" maxlength="195" required></textarea>
        <input type="submit" value="Reject" id="submit"/>
    </form>
    <div class="side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/reject_reason.png" alt="">
    </div>
</div>
</body>
<jsp:include page="../general/footer.jsp"/>
</html>