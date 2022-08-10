<%-- 
    Document   : doctorpage
    Created on : Jul 5, 2022, 12:32:11 PM
    Author     : Admin
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="d" class="DAL.DAO"  scope="request"></jsp:useBean>      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is doctor page!</h1>
        
        <table>
        <c:forEach items="${listReport}" var="dt" >            
            <tr>
                <td>${dt.reportID}</td>
                <td>${dt.doctor.account.getLastname()}</td>
                <td>${dt.doctor.account.getFirstname()}</td>
                <td>${dt.doctor.getClassByID(dt.classid).name}</td>                
                <td>${dt.docot.account.getAccount()}</td>
                <td>${dt.description}</td>
                <td>${dt.startDate}</td>
                <td>${dt.endDate}</td>
            </tr>  
        </c:forEach>
            
        </table>
    </body>
</html>
