<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
    <fmt:setBundle basename="locale"/>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/statisticsStyle.css">
</head>
<body>
<div class="statistic-row">
    <div class="statistic-tile">
        <div class="icon">
            <i class="fas fa-poll"></i>
        </div>
        <div class="statistic-text">
            <p class="statistic-name"><fmt:message key="admin.statistic.applications"/></p>
            <p class="statistic-value">${sessionScope.count_of_applications}</p>
        </div>
    </div>

    <div class="statistic-tile">
        <div class="icon">
            <i class="fas fa-clipboard-check"></i>
        </div>
        <div class="statistic-text">
            <p class="statistic-name"><fmt:message key="admin.statistic.responded_applications"/></p>
            <p class="statistic-value">${sessionScope.count_of_responded_applications}</p>
        </div>
    </div>

    <div class="statistic-tile">
        <div class="icon">
            <i class="fas fa-users"></i>
        </div>
        <div class="statistic-text">
            <p class="statistic-name"><fmt:message key="admin.statistic.administrators"/></p>
            <p class="statistic-value">${sessionScope.count_of_administrators}</p>
        </div>
    </div>

    <div class="statistic-tile">
        <div class="icon">
            <i class="fas fa-user-graduate"></i>
        </div>
        <div class="statistic-text">
            <p class="statistic-name"><fmt:message key="admin.statistic.applicants"/></p>
            <p class="statistic-value">${sessionScope.count_of_applicants}</p>
        </div>
    </div>
</div>

<div class="text-title">
    <h2><fmt:message key="admin.statistic.main_indicators_of_university"/></h2>
</div>

<div class="diagram-row">
    <div class="users-diagram">
        <canvas id="users-bar-diagram"></canvas>
    </div>
    <div class="applications-diagram">
        <canvas id="applications-doughnut-diagram"></canvas>
    </div>
</div>

<div class="text-title">
    <h2><fmt:message key="admin.statistic.average_score_by_faculties"/></h2>
</div>


<div class="faculty-score-row">
    <c:forEach var="faculty_admission_info" items="${sessionScope.faculties_admission_info_list}">
        <div class="faculty-score-container">
            <div class="faculty-data">
                <div class="icon">
                    <i class="fas fa-graduation-cap"></i>
                </div>
                <table>
                    <tr>
                        <td class="faculty-value-name"><b><fmt:message key="faculties_page.faculty_title"/></b></td>
                        <c:choose>
                            <c:when test="${faculty_admission_info.facultyId == 1}">
                                <td class="faculty-value"><fmt:message key="faculties_page.eecs"/></td>
                            </c:when>
                            <c:when test="${faculty_admission_info.facultyId == 2}">
                                <td class="faculty-value"><fmt:message key="faculties_page.meche"/></td>
                            </c:when>
                            <c:when test="${faculty_admission_info.facultyId == 3}">
                                <td class="faculty-value"><fmt:message key="faculties_page.dss"/></td>
                            </c:when>
                        </c:choose>
                    </tr>
                    <tr>
                        <td class="faculty-value-name"><b><fmt:message key="faculties_page.passing_score"/></b></td>
                        <td class="faculty-value">${faculty_admission_info.passingScore}</td>
                    </tr>
                </table>
            </div>
            <a class="edit-faculty"
               href="<c:url value="/controller?command=go_to_edit_average_score_page&selected_faculty_id=${faculty_admission_info.facultyId}&selected_faculty_score=${faculty_admission_info.passingScore}" />"><fmt:message
                    key="admin.statistic.edit"/></a>
        </div>
    </c:forEach>

<%--    <div class="faculty-container">--%>
<%--        <div class="faculty-data">--%>
<%--            <div class="icon">--%>
<%--                <i class="fas fa-graduation-cap"></i>--%>
<%--            </div>--%>
<%--            <table>--%>
<%--                <tr>--%>
<%--                    <td class="faculty-value-name"><b><fmt:message key="admin.statistic.faculty_title"/></b></td>--%>
<%--                    <td class="faculty-value"><fmt:message key="admin.statistic.eecs"/></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td class="faculty-value-name"><b><fmt:message key="admin.statistic.passing_score"/></b></td>--%>
<%--                    <td class="faculty-value">270</td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--        <a class="edit-faculty"--%>
<%--           href="<c:url value="/controller?command=go_to_edit_average_score_page&selected_faculty_id=1&selected_faculty_name=EESS&selected_faculty_score=270" />"><fmt:message--%>
<%--                key="admin.statistic.edit"/></a>--%>
<%--    </div>--%>

<%--    <div class="faculty-container">--%>
<%--        <div class="faculty-data">--%>
<%--            <div class="icon">--%>
<%--                <i class="fas fa-graduation-cap"></i>--%>
<%--            </div>--%>
<%--            <table>--%>
<%--                <tr>--%>
<%--                    <td class="faculty-value-name"><b><fmt:message key="admin.statistic.faculty_title"/></b></td>--%>
<%--                    <td class="faculty-value"><fmt:message key="admin.statistic.meche"/></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td class="faculty-value-name"><b><fmt:message key="admin.statistic.passing_score"/></b></td>--%>
<%--                    <td class="faculty-value">250</td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--        <a class="edit-faculty"--%>
<%--           href="<c:url value="/controller?command=go_to_edit_average_score_page&selected_faculty_id=2&selected_faculty_name=MECHE&selected_faculty_score=250" />"><fmt:message--%>
<%--                key="admin.statistic.edit"/></a>--%>
<%--    </div>--%>

<%--    <div class="faculty-container">--%>
<%--        <div class="faculty-data">--%>
<%--            <div class="icon">--%>
<%--                <i class="fas fa-graduation-cap"></i>--%>
<%--            </div>--%>
<%--            <table>--%>
<%--                <tr>--%>
<%--                    <td class="faculty-value-name"><b><fmt:message key="admin.statistic.faculty_title"/></b></td>--%>
<%--                    <td class="faculty-value"><fmt:message key="admin.statistic.dss"/></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td class="faculty-value-name"><b><fmt:message key="admin.statistic.passing_score"/></b></td>--%>
<%--                    <td class="faculty-value">200</td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--        <a class="edit-faculty"--%>
<%--           href="<c:url value="/controller?command=go_to_edit_average_score_page&selected_faculty_id=3&selected_faculty_name=DSS&selected_faculty_score=200" />"><fmt:message--%>
<%--                key="admin.statistic.edit"/></a>--%>
<%--    </div>--%>

</div>
</body>
</html>


<script>
    const dataBar = {
        labels: [
            '<fmt:message key="admin.statistic.administrators"/>',
            '<fmt:message key="admin.statistic.applicants"/>',
        ],
        datasets: [{
            label: '<fmt:message key="admin.statistic.users_diagram"/>',
            data: [${sessionScope.count_of_administrators}, ${sessionScope.count_of_applicants}],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)'
            ],
            hoverOffset: 4
        }]
    };

    const configBar = {
        type: 'bar',
        data: dataBar,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };

    const chartBar = new Chart(
        document.getElementById('users-bar-diagram'),
        configBar
    );


    const dataDoughnut = {
        labels: [
            '<fmt:message key="admin.statistic.applications"/>',
            '<fmt:message key="admin.statistic.responded_applications"/>',
        ],
        datasets: [{
            label: '<fmt:message key="admin.statistic.applications_diagram"/>',
            data: [${sessionScope.count_of_applications}, ${sessionScope.count_of_responded_applications}],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)'
            ],
            hoverOffset: 4
        }]
    };

    const configDoughnut = {
        type: 'doughnut',
        data: dataDoughnut,
    };

    const chartDoughnut = new Chart(
        document.getElementById('applications-doughnut-diagram'),
        configDoughnut
    );
</script>
