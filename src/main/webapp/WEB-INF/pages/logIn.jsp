<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="locale"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="login.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/logInStyle.css">
</head>
<body>
<div class="container">
    <form action="" class="form">
        <h1><fmt:message key="login.welcome_back"/></h1>
        <label class="prev-text"><fmt:message key="login.email"/></label>
        <input type="email" name="email" class="box" placeholder="<fmt:message key="login.email_placeholder"/>"/>
        <label class="prev-text"><fmt:message key="login.password"/></label>
        <input type="password" name="password" class="box"
               placeholder="<fmt:message key="login.password_placeholder"/>"/>
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