<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="login.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/logInStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
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
        <input type="hidden" name="command" value="login">
        <h1><fmt:message key="login.welcome_back"/></h1>
        <label class="prev-text"><fmt:message key="login.email"/></label>
        <input type="email" name="user_email" class="box"
               placeholder="<fmt:message key="login.email_placeholder"/>" maxlength="70" required/>
        <label class="prev-text"><fmt:message key="login.password"/></label>
        <input type="password" name="user_password" class="box"
               placeholder="<fmt:message key="login.password_placeholder"/>"
               minlength="8" maxlength="30" required/>
        <input type="submit" value="<fmt:message key="login.sign_in"/>" id="submit"/>
        <a href="#"><fmt:message key="login.forget_password"/></a>
    </form>
    <div class="image-side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/login.png"
             alt="<fmt:message key="login.sign_in"/>">
    </div>
</div>

</body>
</html>