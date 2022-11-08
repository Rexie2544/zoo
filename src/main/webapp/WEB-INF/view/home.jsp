<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>หน้าหลัก </title>
    <link href="${pageContext.request.contextPath}/assets/css/WebCSS.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
<center>

<div style="width: 100%;float: left">
    <div>
        <center><img class="log-fl" src="${pageContext.request.contextPath}/assets/img/z.jpg" style="height: 80%"></center>
    </div>
    <div><center>
        <br><br>  <br><br>  <br><br><br>  <br>
        <h2>ยินดีต้อนรับเข้าสู่</h2>
        <h1>สวนสัตว์เชียงใหม่</h1>
        <p>เว็บไซต์นี้เป็นเว็บไซต์สำหรับนำทางให้กับผู้ที่สนใจท่องเที่ยวในส่วนสัตว์เชียงใหม่
       สวนสัตว์เชียงใหม่ องค์การสวนสัตว์แห่งประเทศไทยในพระบรมราชูถัมภ์  กระทรวงทรัพยากรธรรมชาติและสิ่งแวดล้อม</p>
    </center></div>
</div>
    <div style="width: 100%;float: left;">
        <h1>แผนที่สวนสัตว์เชียงใหม่</h1>
        <div style="width: 100%">
            <center><img src="${pageContext.request.contextPath}/assets/img/MAP.png" style="width: 60%"></center>
        </div>
            <h2>ข้อมูลรถราง</h2>
        <div>
            <c:forEach var="tram" items="${trams}">
                <div style="width: 25%;float: left">

                    <p> <b> รถรางสาย :</b> ${tram.tramID}<br>
                        <b>เวลา : </b> ${tram.timef} - ${tram.timel}</p>
                </div>

            </c:forEach>
        </div>
        <div style="width: 100%">
            <thead>

                <h2>ข้อมูลสัตว์</h2>

            </thead>
            <tbody>

            <c:forEach var="animal" items="${animals}" >
                    <div style="width: 45%;float: left;margin: 10px ;margin-left: 50px">
                        <table>
                            <tr style="height: 325px">
                                <td><img src="${pageContext.request.contextPath}/assets/img/${(animal.animalID)}.jpg" style="width: 200px ;margin: 5px;"></td>
                                <td>
                                    <p><b>ชื่อไทย : </b>${animal.nameTH}
                                        <br><b>ชื่อภาษาอังกฤษ : </b>${(animal.nameEN)}
                                        <br><b>ชื่อวิทยาศาสตร์ : </b>${(animal.nameSC)}
                                        <br><b>รายละเอียด : </b>${(animal.details)}
                                        <br><b>อาหารที่ชอบ : </b>${(animal.food)}</p><br>
                                </td>
                            </tr>
                        </table>
                    </div>
            </c:forEach>
            </tbody>
        </div>
    </div>
</center>

<div style="width: 100%;float: left">
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</div>
</body>
</html>
