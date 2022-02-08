<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title><fmt:message key="profile.title"/></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/editProfileStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<c:if test="${sessionScope.input_hint_status == 'SHOW'}">
    <div class="input-hint-block">
        <h1 class="input-hint-header"><fmt:message key="edit_profile.input_hint.title"/></h1>
        <p class="input-hint-message"><fmt:message key="edit_profile.input_hint.message"/></p>
    </div>
</c:if>
<div class="container">
    <form action="controller" class="form" method="post">
        <input type="hidden" name="command" value="edit_personal_data">
        <h1><fmt:message key="edit_profile.title"/></h1>
        <div class="row">
            <div class="column">
                <label class="prev-text">
                    <fmt:message key="edit_profile.first_name"/><em>*</em>
                    <input type="text" name="user_name" class="box"
                           value="${sessionScope.user_name}"
                           placeholder="<fmt:message key="edit_profile.first_name_placeholder"/>" maxlength="50"
                           required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="edit_profile.email"/><em>*</em>
                    <input type="email" name="user_email" class="box"
                           value="${sessionScope.user_email}"
                           placeholder="<fmt:message key="edit_profile.email_placeholder"/> " maxlength="70" required/>
                </label>
            </div>
            <div class="column">
                <label class="prev-text">
                    <fmt:message key="edit_profile.last_name"/><em>*</em>
                    <input type="text" name="user_surname" class="box"
                           value="${sessionScope.user_surname}"
                           placeholder="<fmt:message key="edit_profile.last_name_placeholder"/>" maxlength="70"
                           required/>
                </label>
                <label class="prev-text">
                    <fmt:message key="edit_profile.passport_id"/><em>*</em>
                    <input type="text" name="user_passport_id" class="box"
                           value="${sessionScope.user_passport_id}"
                           placeholder="<fmt:message key="edit_profile.passport_id_placeholder"/>" maxlength="9"
                           required/>
                </label>
            </div>
        </div>

        <div class="input-hint-row">
            <div class="column-input-hint-bottom">
                <a href="<c:url value="/controller?command=change_input_hint_status" />" class="show-input-hint-button">
                    <c:if test="${sessionScope.input_hint_status == null || sessionScope.input_hint_status == 'HIDE'}">
                        <fmt:message key="edit_profile.input_hint.show_input_hint_button"/>
                    </c:if>
                    <c:if test="${sessionScope.input_hint_status == 'SHOW'}">
                        <fmt:message key="edit_profile.input_hint.hide_input_hint_button"/>
                    </c:if>
                </a>
            </div>
        </div>
        <input type="submit" class="form-edit-btn" value="<fmt:message key="edit_profile.save_button"/>">

    </form>
    <div class="image-side">
        <img class="image" src="${pageContext.request.contextPath}/assets/image/signup.png"
             alt="<fmt:message key="edit_profile.title"/>">
    </div>
</div>
</body>
<jsp:include page="general/footer.jsp"/>
</html>
