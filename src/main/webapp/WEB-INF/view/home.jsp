<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>หน้าหลัก </title>
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
<center>

<div style="width: 100%;float: left">
    <center><img class="log-fl" src="${pageContext.request.contextPath}/assets/img/Log-in1.png" style="height: 80%"></center>
</div>
    <div style="width: 100%;float: left">
        <center><img src="${pageContext.request.contextPath}/assets/img/zoo.png" style="width: 500px"></center>
    </div>
</center>

<div style="width: 100%;float: left">
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</div>
</body>
</html>
