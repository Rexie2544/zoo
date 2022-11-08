<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/style.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="width: 100% ; float: left;background-color: #162434;height: 5%;">

    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
<center>
    <h1>Access Denied</h1>
    <hr>
    <div class="container">
        <h2 style="text-align: center;">คุณไม่ได้รับอนุญาตให้เข้าถึงหน้าเว็บนี้</h2>
        <div style="width: 100%;float: left">
            <center><img class="log-fl" src="${pageContext.request.contextPath}/assets/img/E.jpg" style="width: 70%"></center>
        </div>
    </div>
</center>
<div style="width: 100%;float: left">
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</div>
</body>
</html>

