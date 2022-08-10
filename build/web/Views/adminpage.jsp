<%-- 
    Document   : adminpage
    Created on : Jul 9, 2022, 11:23:45 PM
    Author     : Admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="d" class="DAL.DAO"  scope="request"></jsp:useBean> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <header class="header menu-fixed">
            <div class="container-header">
                
            </div>
        </header>
        
        <h1>DOCTOR TABLE</h1>
        <table>
            <tr>
                <td><a href="newdoctorpage?prepage=${prePage}"><input type="submit" value="create" title="create new doctor"></a></td>
            </tr>
            <tr>
                <td>ID</td>
                <td>Last name</td>
                <td>First name</td>
                <td>Gender</td>
                <td>Date of birth</td>
                <td>Address</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Class</td>                
                <td>Account</td>
            </tr>
        <c:forEach items="${d.loadDoctor()}" var="dt" >            
            <tr>
                <td>${dt.doctorid}</td>
                <td>${dt.account.getLastname()}</td>
                <td>${dt.account.getFirstname()}</td> 
                <td>${dt.account.getGender()?'Male':'Female'}</td>
                <td>${dt.account.getDob()}</td>
                <td>${dt.account.getAddress()}</td>
                <td>${dt.account.getEmail()}</td>
                <td>${dt.account.getPhone()}</td>
                <td>${d.getClassByID(dt.classid).name}</td>                
                <td>${dt.account.getAccount()}</td>
                <td><a href="editdoctorpage?doctorid=${dt.doctorid}&prepage=${prePage}"><input type="submit" value="edit"></a></td>
                <td><a href="deletedoctor?doctorid=${dt.doctorid}"><input type="submit" value="delete"></a></td>
            </tr>  
        </c:forEach>            
        </table>
        
        <h1>PATIENT TABLE</h1>   
        <table>
            <tr>
                <td>ID</td>
                <td>Last name</td>
                <td>First name</td>
                <td>Gender</td>
                <td>Date of birth</td>
                <td>Address</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Status</td>                
                <td>Account</td>
            </tr>
        <c:forEach items="${d.loadPatient()}" var="dt" >  
            
            <tr>
                <td>${dt.patientid}</td>
                <td>${dt.account.getLastname()}</td>
                <td>${dt.account.getFirstname()}</td> 
                <td>${dt.account.getGender()?'Male':'Female'}</td>
                <td>${dt.account.getDob()}</td>
                <td>${dt.account.getAddress()}</td>
                <td>${dt.account.getEmail()}</td>
                <td>${dt.account.getPhone()}</td>
                <td>${dt.status}</td>                
                <td>${dt.account.getAccount()}</td>
                <td><a href="editpatientpage?patientid=${dt.patientid}&prepage=${prePage}"><input type="submit" value="edit"></a></td>
                <td><a href="deletepatient?patientid=${dt.patientid}"><input type="submit" value="delete"></a></td>
               
            </tr>  
        </c:forEach>            
        </table>
<!--            <script>
               console.log(); 
            </script>-->
            
    </body>
</html>
