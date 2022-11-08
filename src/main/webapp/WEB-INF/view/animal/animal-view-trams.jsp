<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<body>

<div style="width: 100% ; float: left;background-color: #162434;height: 5%"><jsp:include page="/WEB-INF/view/layouts/nav.jsp"/></div>
<div class="container">
    <center>
        <div id="header"><h1>${title}</h1></div>
        <input type="button" value="เพิ่มสัตว์"
               onclick="window.location.href=
                       '${pageContext.request.contextPath}/animal/${animal.id}/tram/add';
                       return false;"
               class="add-button"
        />
    </center>
   <div style="width: 100%;float: left">
       <center>
           <table class="table-bordered" style="width: 80%">
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
       </center>
   </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
