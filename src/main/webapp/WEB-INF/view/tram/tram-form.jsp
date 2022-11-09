<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<div class="container" style="width: 100%;float: left ;background-color: #fff4ec">
    <center>
        <div id="container">
            <div id="header"><h1>${title}</h1></div>
            <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน <b style="color: red">(*)</b> หมายถึงห้ามว่าง</i><br><br>
            <form:form action="${pageContext.request.contextPath}/tram/save " modelAttribute="tram" method="POST">
                <form:hidden path="id"/>
                <table class="ifinput">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <td><label>รหัสรถราง <b style="color: red">*</b></label></td>
                        <td><form:input path="tramID"/>
                            <form:errors path="tramID" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>จุดจอดรถ</label></td>
                        <td><form:input path="parking"/>
                            <form:errors path="parking" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>จุดที่ส่ง</label></td>
                        <td><form:input path="route"/>
                            <form:errors path="route" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>เวลาเริ่มทำงาน</label></td>
                        <td><form:input path="timef" cssClass="number" alt="7.30 น."/>
                            <form:errors path="timef" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>เวลาเลิกงาน</label></td>
                        <td><form:input path="timel" cssClass="number" alt="16.30 น."/>
                            <form:errors path="timel" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td>
                            <input type="submit" value="บันทึก" class="save-button" style="height: 45px;color: white"/>
                            <input type="button" value="ลบ"
                                   onclick="if((confirm('คูณแน่ใจหรือว่าต้องการลบรถรางนี้ ?'))) {
                                           window.location.href='${pageContext.request.contextPath}/tram/${tram.id}/delete'; return false; }"
                                   class="cancel-button" style="background-color: red;height: 45px;color: white"
                            />
                            <input type="button" value="ยกเลิก"
                                   onclick="window.location.href='${pageContext.request.contextPath}/tram/list'; return false;"
                                   class="cancel-button" style="background-color: #162434;color: white;height: 45px"
                            />
                            <c:if test="${tram.id > 0}">
                                <input type="button" value="แสดงรถราง"
                                       onclick="window.location.href=
                                               '${pageContext.request.contextPath}/tram/${tram.id}/view-animals';
                                               return false;"
                                       class="add-button"
                                />
                            </c:if>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
        </div>
    </center>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>

</body>
</html>
