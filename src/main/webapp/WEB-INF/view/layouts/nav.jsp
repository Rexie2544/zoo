<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>

<head>
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<nav class="nav">

    <ul>
        <li>
                <center><img class="log-fl" src="${pageContext.request.contextPath}/assets/img/LOGO.png" style="height: 60px;margin-top: -20px"></center>
        </li>
        <li><a><h3>Chiang Mai - Zoo</h3></a></li>
        <li class ="Home-padding"><a href="${pageContext.request.contextPath}">หน้าหลัก</a></li>
        <security:authorize access="hasRole('MANAGER')">
        <li><a href="${pageContext.request.contextPath}/animal/list">สัตว์</a></li>
        </security:authorize>


        <security:authorize access="hasRole('ADMIN')">
        <li><a href="${pageContext.request.contextPath}/tram/list">รถราง</a></li>
        </security:authorize>

        <security:authorize access="!isAuthenticated()">
            <li><a href="${pageContext.request.contextPath}/login" >ลงชื่อเข้าสู่ระบบ</a></li>
        </security:authorize>

        <security:authorize access="isAuthenticated()">
        <li><a href="#" onclick="javascript: frmLogout.submit();">ลงชื่อออกจากระบบ</a></li>
            <li>
                <a><h4>[ <security:authentication property="principal.username" /> ]</h4></a>
            </li>
        </security:authorize>
    </ul>
</nav>
<hr>
