<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>${title}</h1>
<div class="container">
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <input type="button" value="เพิ่มรถราง"
           onclick="window.location.href='${pageContext.request.contextPath}/tram/create'; return false;"
           class="add-button"
    />
    <table>
        <thead>
        <tr>
            <th>รหัสรถราง</th><th>จุดเริ่มต้น</th><th>จุดสิ้นสุด</th><th>เวลาขนส่ง</th><th>จำนวนสัตว์</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tram" items="${trams}">
            <tr>
                <td><a href="${pageContext.request.contextPath}/tram/${tram.id}/update">
                        ${tram.tramID}</a></td>
                <td>${tram.parking}</td>
                <td>${tram.route}</td>
                <td>${tram.timef} - ${tram.timel}</td>
                <td>${fn:length(tram.animals)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>