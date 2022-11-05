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
    <input type="button" value="เพิ่มร้านค้า"
           onclick="window.location.href=
                   '${pageContext.request.contextPath}/product/${product.id}/shop/add';
                   return false;"
           class="add-button"
    />
    <table class="table-bordered">
        <thead>
        <tr>
            <th>รหัสร้านค้า</th><th>ชื่อร้านค้า</th><th>ชื่อเจ้าของ</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="shop" items="${shops}">
            <tr>
                <td class="center">
                    <a href="${pageContext.request.contextPath}/shop/${shop.id}/update">${shop.code}</a>
                </td>
                <td>${shop.name}</td>
                <td>${shop.owner}</td>
                <td class="center"><a
                        href="${pageContext.request.contextPath}/product/${product.id}/shop/${shop.id}/remove">ลบ</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
