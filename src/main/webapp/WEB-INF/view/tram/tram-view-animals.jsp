<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
           onclick="window.location.href='${pageContext.request.contextPath}/tram/${tram.id}/animal/add';
                   return false;"
           class="add-button"
    />
    <table class="table-bordered">
        <thead>
        <tr>
            <th>รหัสสัตว์</th>
            <th>ชื่อไทย</th>
            <th>ชื่ออังกฤษ</th>
            <th>ชื่อวิทยาศาสตร์</th>
            <th>จำนวนรถราง</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="animal" items="${animals}">
            <tr>
                <td class="center">
                    <a href="${pageContext.request.contextPath}/animal/${animal.id}/update">${animal.animalID}</a>
                </td>
                <td>${animal.nameTH}</td>
                <td class="center">${(animal.nameEN)}</td>
                <td class="center">${(animal.nameSC)}</td>
                <td class="center">${fn:length(animal.trams)}</td>
                <td class="center"><a
                        href="${pageContext.request.contextPath}/tram/${tram.id}/animal/${animal.id}/remove">ลบ</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
