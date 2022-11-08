<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<body>

<div style="width: 100% ; float: left;background-color: #162434;height: 5%;margin-top: -150px">
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
   <div class="container" style="width: 100%;float: left;background-color:#fff4ec">
       <center>

           <div id="header"><h1>${title}</h1></div>
           <form action ="${pageContext.request.contextPath}/animal/${animal.id}/tram/add" method="post">
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
                           <td class="center">
                               <button type="submit" name="tram" value="${tram.id}" style="background-color: #162434;color: white;width: 100px;height: 45px"> เพิ่ม </button>
                           </td>
                       </tr>
                   </c:forEach>
                   </tbody>

               </table>
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
           </form>
       </center>
   </div>

<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>
