<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header"><h1>${title}</h1></div>
<div class="container">
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <input type="button" value="เพิ่มสัตว์"
           onclick="window.location.href=
                   '${pageContext.request.contextPath}/animal/${animal.id}/tram/add';
                   return false;"
           class="add-button"
    />
    <table class="table-bordered">
        <thead>
        <tr>
            <th>รหัสรถราง</th><th>จุดเริ่มต้น</th><th>จุดสิ้นสุด</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tram" items="${trams}">
            <tr>
                <td class="center">
                    <a href="${pageContext.request.contextPath}/tram/${tram.id}/update">${tram.tramID}</a>
                </td>
                <td>${tram.parking}</td>
                <td>${tram.route}</td>
                <td class="center"><a
                        href="${pageContext.request.contextPath}/animal/${animal.id}/tram/${tram.id}/remove">ลบ</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>