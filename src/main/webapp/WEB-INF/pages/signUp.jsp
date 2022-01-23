<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="signup.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signUpStyle.css">
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
        <input type="hidden" name="command" value="signup">
        <h1><fmt:message key="signup.sign_up"/></h1>
        <div class="row">
            <div class="column">
                <label class="prev-text">
                    <fmt:message key="signup.first_name"/><em>*</em>
                    <input type="text" name="user_name" class="box"
                           placeholder="<fmt:message key="signup.first_name_placeholder"/>" maxlength="50" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.email"/><em>*</em>
                    <input type="email" name="user_email" class="box"
                           placeholder="<fmt:message key="signup.email_placeholder"/> " maxlength="70" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.password"/><em>*</em>
                    <input type="password" name="user_password" class="box"
                           placeholder="<fmt:message key="signup.password_placeholder"/>"
                           minlength="8" maxlength="30" required/>
                </label>
            </div>
            <div class="column">
                <label class="prev-text">
                    <fmt:message key="signup.last_name"/><em>*</em>
                    <input type="text" name="user_surname" class="box"
                           placeholder="<fmt:message key="signup.last_name_placeholder"/>" maxlength="70" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.passport_id"/><em>*</em>
                    <input type="text" name="user_passport_id" class="box"
                           placeholder="<fmt:message key="signup.passport_id_placeholder"/>" maxlength="9" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.confirm_password"/><em>*</em>
                    <input type="password" name="confirm_password" class="box"
                           placeholder="<fmt:message key="signup.confirm_password_placeholder"/>"
                           minlength="8" maxlength="30" required/>
                </label>
            </div>
        </div>

        <input type="submit" class="form-sign-up-btn" value="<fmt:message key="signup.sign_up_button"/>">

        <div class="row">
            <div class="column-bottom">
                <label class="prev-text"><fmt:message key="signup.already_have_account"/></label>
            </div>
            <div class="column-bottom">
                <a href="<c:url value="/controller?command=go_to_log_in_page" />" class="sign-in-button"><fmt:message
                        key="signup.sign_in"/></a>
            </div>
        </div>

    </form>
    <div class="image-side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/signup.png"
             alt="<fmt:message key="login.sign_in"/>">
    </div>
</div>
</body>
</html>
