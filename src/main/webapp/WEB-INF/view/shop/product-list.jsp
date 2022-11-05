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
    <form action="${pageContext.request.contextPath}/shop/${shop.id}/product/add"   method="post">
    <table class="table-bordered">
        <thead>
        <tr>
            <th>รหัสสินค้า</th><th>ชื่อสินค้า</th><th>ราคา</th><th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td class="center">
                    <a href="${pageContext.request.contextPath}/product/${product.id}/update">${product.code}</a>

                </td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td class="center"><button type="submit" name="product" value="${product.id}">
                    เพิม </button></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    </form>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
