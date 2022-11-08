<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>หน้าหลัก </title>
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
<center>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
    <div>
        <center><img src="${pageContext.request.contextPath}/assets/img/zoo.png" style="width: 500px"></center>
    </div>
</center>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
