<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>${title}</title></head>
<body>
<div>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
<div>
    <center><img class="log-fl" src="${pageContext.request.contextPath}/assets/img/Log-in1.png" style="height: 86%"></center>
</div>
<center><h1 class="mar-log">${title}</h1></center>
<link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/Login.css.css" rel="stylesheet" type="text/css">
<div class="Login">
    <c:if test="${param.error != null}">ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง</c:if>
    <c:if test="${param.logout != null}">คุณออกจากระบบแล้ว</c:if>
    <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
        <p>ชื่อผู้ใช้: </p>
        <input type="text" name="username"/>
        <p>รหัสผ่าน: </p>
        <input type="password" name="password"/><br><br><br>
        <input class="submit" type="submit" value="เข้าสู่ระบบ"/>
    </form:form>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
