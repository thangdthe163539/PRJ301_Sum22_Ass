<%-- 
    Document   : recordpage
    Created on : Jul 14, 2022, 10:19:49 AM
    Author     : Admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="r" class="DAL.DAO"  scope="request"></jsp:useBean> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            <div>RecordId: ${rec.recordID}</div>
            <c:if test="${rec.status==true}">
                <a href=""><input type="button" name="edit" value="edit"></a>
            </c:if>
            <div>Doctor: ${rec.doctor.getFirstname()} ${rec.doctor.getLastname()}</div>
            <div>Start date: ${rec.startDate}</div><div>End date: ${rec.endDate}</div>
            <p>Description: ${rec.description}</p>
            <p>Detail: ${rec.detail}</p>
        </form>
        <form action="recordpage" method="post">
            <input type="text" name="recordID" value="${rec.recordID}">
            <div>Doctor: ${rec.doctor.getFirstname()} ${rec.doctor.getLastname()}</div>
            <div>Start date:<input type="date" name="startdate" value="${rec.startDate}"></div>
            <div>End date:<input type="date" name="enddate" value="${rec.endDate}"></div>
            <p>Description: ${rec.description}</p>
            <p>Detail: ${rec.detail}</p>
            <input type="hidden" name="description" value="${rec.description}">
            <input type="hidden" name="detail" value="${rec.detail}">
            <input type="submit" value="update">
        </form>
        
    </body>
</html>
