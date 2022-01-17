<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="locale"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="signup.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signUpStyle.css">
</head>
<body>
<div class="container">
    <form action="" class="form">
        <h1><fmt:message key="signup.sign_up"/></h1>
        <div class="row">
            <div class="column">
                <label class="prev-text"><fmt:message key="signup.first_name"/></label>
                <input type="text" name="" class="box"
                       placeholder="<fmt:message key="signup.first_name_placeholder"/>"/>
                <label class="prev-text"><fmt:message key="signup.email"/></label>
                <input type="email" name="" class="box" placeholder="<fmt:message key="signup.email_placeholder"/>"/>
                <label class="prev-text"><fmt:message key="signup.password"/></label>
                <input type="password" name="password" class="box"
                       placeholder="<fmt:message key="signup.password_placeholder"/>"/>
            </div>
            <div class="column">
                <label class="prev-text"><fmt:message key="signup.last_name"/></label>
                <input type="text" name="" class="box" placeholder="<fmt:message key="signup.last_name_placeholder"/>"/>
                <label class="prev-text"><fmt:message key="signup.passport_id"/></label>
                <input type="text" name="" class="box"
                       placeholder="<fmt:message key="signup.passport_id_placeholder"/>"/>
            </div>
        </div>

        <input type="submit" value="<fmt:message key="signup.sign_up_button"/>" id="submit"/>
        <div class="row">
            <div class="column-bottom">
                <label class="prev-text"><fmt:message key="signup.already_have_account"/></label>
            </div>
            <div class="column-bottom">
                <a href="#" class="sign-in-button"><fmt:message key="signup.sign_in"/></a>
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
