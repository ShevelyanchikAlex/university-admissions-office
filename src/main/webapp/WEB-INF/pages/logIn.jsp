<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="login.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/logInStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<c:if test="${sessionScope.input_hint_status == 'SHOW'}">
    <div class="input-hint-block">
        <h1 class="input-hint-header"><fmt:message key="login.input_hint.title"/></h1>
        <p class="input-hint-message"><fmt:message key="login.input_hint.message"/></p>
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

        <div class="input-hint-row">
            <div class="column-input-hint-bottom">
                <a href="<c:url value="/controller?command=change_input_hint_status" />" class="show-input-hint-button">
                    <c:if test="${sessionScope.input_hint_status == null || sessionScope.input_hint_status == 'HIDE'}">
                        <fmt:message key="login.input_hint.show_input_hint_button"/>
                    </c:if>
                    <c:if test="${sessionScope.input_hint_status == 'SHOW'}">
                        <fmt:message key="login.input_hint.hide_input_hint_button"/>
                    </c:if>
                </a>
            </div>
        </div>
        <input type="submit" value="<fmt:message key="login.sign_in_button"/>" id="submit"/>
        <a href="<c:url value="/controller?command=go_to_sign_up_page" />"><fmt:message
                key="login.have_not_an_account"/></a>
    </form>
    <div class="image-side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/login.png"
             alt="<fmt:message key="login.title"/>">
    </div>
</div>
</body>
<jsp:include page="general/footer.jsp"/>
</html>