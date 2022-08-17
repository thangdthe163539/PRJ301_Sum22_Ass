<%-- 
    Document   : WorkingTimeReport
    Created on : Aug 17, 2022, 5:01:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px solid">
            <tr>
                <td>Họ và tên</td>
                <td>Mã NV</td>
                <td>Bộ phận</td>
                <td>Chức vụ</td>
            </tr>
            <c:forEach var="em" items="${requestScope.employees}" >
                <tr>
                    <td>${em.name}</td>
                    <td>${em.ecode}</td>
                    <td>${em.department}</td>
                    <td>${em.position}</td>
                </tr>   
            </c:forEach>
        </table>
    </body>
</html>
