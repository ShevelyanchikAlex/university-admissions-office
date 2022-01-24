<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="profile.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/profileStyle.css">
</head>
<body>
<jsp:include page="general/header.jsp"/>
<div class="profile-container">
    <div class="profile-data">
        <div class="personal-data">
            <h1 class="email"><i class="far fa-user-circle avatar"></i>${sessionScope.user_email}</h1>
            <table>
                <tr>
                    <td class="personal-data-name"><b><fmt:message key="profile.personal.data.name"/></b></td>
                    <td class="personal-data-value">${sessionScope.user_name}</td>
                </tr>
                <tr>
                    <td class="personal-data-name"><b><fmt:message key="profile.personal.data.surname"/></b></td>
                    <td class="personal-data-value">${sessionScope.user_surname}</td>
                </tr>
                <tr>
                    <td class="personal-data-name"><b><fmt:message key="profile.personal.data.passport_data"/></b></td>
                    <td class="personal-data-value">${sessionScope.user_passport_id}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<a class="edit-profile" href="<c:url value="/controller?command=go_to_edit_personal_data_page" />"><fmt:message
        key="profile.personal.data.edit_button"/></a>

<c:if test="${sessionScope.user_role == 'USER'}">
    <div class="application-container">
        <div class="application-data">
            <div class="application-personal-data">
                <h1 class="application-header"><fmt:message key="profile.application.data.header"/></h1>
                <table>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message key="profile.application.data.faculty"/></b></td>
                        <td class="personal-data-value">KSIS</td>
                    </tr>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message
                                key="profile.application.data.date_of_application"/></b></td>
                        <td class="personal-data-value">07.07.2022</td>
                    </tr>

                    <tr>
                        <td class="personal-data-name"><b><fmt:message
                                key="profile.application.data.first_subject_points"/></b></td>
                        <td class="personal-data-value">90</td>
                    </tr>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message
                                key="profile.application.data.second_subject_points"/></b></td>
                        <td class="personal-data-value">80</td>
                    </tr>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message
                                key="profile.application.data.third_subject_points"/></b></td>
                        <td class="personal-data-value">75</td>
                    </tr>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message key="profile.application.data.confirmed"/></b>
                        </td>
                        <td class="personal-data-value">yes</td>
                    </tr>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message
                                key="profile.application.data.confirmation_date"/></b></td>
                        <td class="personal-data-value">21.07.2022</td>
                    </tr>
                    <tr>
                        <td class="personal-data-name"><b><fmt:message
                                key="profile.application.data.rejection_reason"/></b>
                        </td>
                        <td class="personal-data-value">Resason</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${sessionScope.user_role == 'USER_WITHOUT_APPLICATION'}">
    <a class="add-application" href=""><fmt:message key="profile.application.add_application_button"/></a>
</c:if>
</body>
</html>
