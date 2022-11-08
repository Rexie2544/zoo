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
<div style="width: 100% ; float: left;background-color: #162434;height: 5%">

    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
</div>
<div class="container" style="width: 100%;float: left">
    <center>
        <div >
            <div ><h1>${title}</h1></div>
            <i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน <b style="color: red">*</b> หมายถึงห้ามว่าง</i><br><br>
            <form:form action="${pageContext.request.contextPath}/animal/save " modelAttribute="animal" method="POST">
                <form:hidden path="id"/>
                <table style="width: 50%" class="ifinput">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <td><label>รหัสสัตว์<b style="color: red">*</b> :</label></td>
                        <td><form:input path="animalID"/>
                            <form:errors path="animalID" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>ชื่อไทย<b style="color: red">*</b> :</label></td>
                        <td><form:input path="nameTH"/>
                            <form:errors path="nameTH" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>ชื่ออังกฤษ<b style="color: red">*</b> :</label></td>
                        <td><form:input path="nameEN" cssClass="number"/>
                            <form:errors path="nameEN" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>ชื่อวิทยาศาสตร์<b style="color: red">*</b> :</label></td>
                        <td><form:input path="nameSC" cssClass="number"/>
                            <form:errors path="nameSC" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>รายละเอียด<b style="color: red">*</b>:</label></td>
                        <td><form:textarea path="details" cols="50" rows="5"></form:textarea>
                            <form:errors path="details" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>ที่อยู่อาศัย<b style="color: red">*</b> :</label></td>
                        <td><form:input path="residence" cssClass="number"/>
                            <form:errors path="residence" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>อาหาร<b style="color: red">*</b> :</label></td>
                        <td><form:input path="food" cssClass="number"/>
                            <form:errors path="food" cssClass="error" style="color:red"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>ประเภทของสัตว์<b style="color: red">*</b></label></td>
                        <td>
                            <form:select path="animalType.typeID">
                                <form:option value="" label="-- กรุณาเลือกประเภท --"/>
                                <form:options items="${animaltypes}" itemLabel="nameType"
                                              itemValue="typeID"/>
                            </form:select>
                            <form:errors path="animalType.typeID" cssClass="error"/>
                        </td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td style="width: 40px">
                            <input type="submit" value="บันทึก" class="save-button" style="height: 45px"/>
                            <input type="button" value="ลบ"
                                   onclick="if((confirm('คูณแน่ใจหรือว่าต้องการลบสัตว์ตัวนี้ ?'))) {
                                           window.location.href='${pageContext.request.contextPath}/animal/${animal.id}/delete'; return false; }"
                                   class="delete-button" style="height: 45px ;background-color: red"
                            />
                            <input type="button" value="ยกเลิก"
                                   onclick="window.location.href='${pageContext.request.contextPath}/animal/list'; return false;"
                                   class="cancel-button" style="height: 45px;background-color: #162434;color: white"
                            />
                            <c:if test="${animal.id > 0}">
                                <input type="button" value="แสดงรถราง"
                                       onclick="window.location.href=
                                               '${pageContext.request.contextPath}/animal/${animal.id}/view-trams';
                                               return false;"
                                       class="add-button" style="height: 45px"
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
<div style="width: 100%;float: left"><jsp:include page="/WEB-INF/view/layouts/footer.jsp"/></div>
</body>
</html>
