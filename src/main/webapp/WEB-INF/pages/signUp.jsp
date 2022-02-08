<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.epam.admissions.office.service.validator.constant.ValidPattern" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="signup.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signUpStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<c:if test="${sessionScope.input_hint_status == 'SHOW'}">
    <div class="input-hint-block">
        <h1 class="input-hint-header"><fmt:message key="signup.input_hint.title"/></h1>
        <p class="input-hint-message"><fmt:message key="signup.input_hint.message"/></p>
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
                           placeholder="<fmt:message key="signup.first_name_placeholder"/>"
                           pattern="${ValidPattern.NAME_PATTERN}" maxlength="50" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.email"/><em>*</em>
                    <input type="email" name="user_email" class="box"
                           placeholder="<fmt:message key="signup.email_placeholder"/> "
                           pattern="${ValidPattern.EMAIL_PATTERN}" maxlength="70" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.password"/><em>*</em>
                    <input type="password" name="user_password" class="box"
                           placeholder="<fmt:message key="signup.password_placeholder"/>"
                           pattern="${ValidPattern.PASSWORD_PATTERN}"
                           minlength="8" maxlength="30" required/>
                </label>
            </div>
            <div class="column">
                <label class="prev-text">
                    <fmt:message key="signup.last_name"/><em>*</em>
                    <input type="text" name="user_surname" class="box"
                           placeholder="<fmt:message key="signup.last_name_placeholder"/>"
                           pattern="${ValidPattern.NAME_PATTERN}" maxlength="70" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.passport_id"/><em>*</em>
                    <input type="text" name="user_passport_id" class="box"
                           placeholder="<fmt:message key="signup.passport_id_placeholder"/>"
                           pattern="${ValidPattern.PASSPORT_SERIES_AND_NUMBER}" maxlength="9" required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="signup.confirm_password"/><em>*</em>
                    <input type="password" name="confirm_password" class="box"
                           placeholder="<fmt:message key="signup.confirm_password_placeholder"/>"
                           pattern="${ValidPattern.PASSWORD_PATTERN}"
                           minlength="8" maxlength="30" required/>
                </label>
            </div>
        </div>

        <div class="input-hint-row">
            <div class="column-input-hint-bottom">
                <a href="<c:url value="/controller?command=change_input_hint_status" />" class="show-input-hint-button">
                    <c:if test="${sessionScope.input_hint_status == null || sessionScope.input_hint_status == 'HIDE'}">
                        <fmt:message key="signup.input_hint.show_input_hint_button"/>
                    </c:if>
                    <c:if test="${sessionScope.input_hint_status == 'SHOW'}">
                        <fmt:message key="signup.input_hint.hide_input_hint_button"/>
                    </c:if>
                </a>
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
             alt="<fmt:message key="login.title"/>">
    </div>
</div>
</body>
<jsp:include page="general/footer.jsp"/>
</html>
