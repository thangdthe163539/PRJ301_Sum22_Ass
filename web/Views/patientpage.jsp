<%-- 
    Document   : patientpage
    Created on : Jul 5, 2022, 12:57:37 PM
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
        <h1>This is patient page!</h1>
        <table>           
            <c:forEach items="${rList}" var="dt" >            
                <tr>
                   <td>${dt.recordID}</td>
                   <td>${dt.doctor.getLastname()}</td>
                   <td>${dt.doctor.getFirstname()}</td>
                   <td>${dt.description}</td>                   
                   <td>${dt.startDate}</td> 
                   <td>
                    <c:if test="${dt.status==true}">
                        <a href="recordpage?recordid=${dt.recordID}"><input type="button" name="edit" value="edit"></a>
                    </c:if>
                   </td>
                   <td><a href="recordpage?recordid=${dt.recordID}"><input type="button" name="detail" value="detail"></a></td>
                </tr>
            </c:forEach>
        
        </table>
        

    </body>
</html>