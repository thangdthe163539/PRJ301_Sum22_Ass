<%-- 
    Document   : editpage
    Created on : Jul 10, 2022, 4:08:40 PM
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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="editpatientpage" method="post">  
            <input type="hidden" name="pPage" value="${sessionScope.prePage}">
            <input type="hidden" name="patientid" value="${pat.patientid}">            
            First name: <input type="text" name="fname" value="${pat.account.getFirstname()}"><br>
            Last name: <input type="text" name="lname" value="${pat.account.getLastname()}"><br>                  
            Date of birth: <input type="date" name="dob" value="${pat.account.getDob()}"><br>
            Address: <input type="text" name="address" value="${pat.account.getAddress()}"><br>
            Email: <input type="text" name="email" value="${pat.account.getEmail()}"><br>
            Phone: <input type="text" name="phone" value="${pat.account.getPhone()}"><br> 
            Status: <select id="slStatus" name="status">
                <option value="true">Active</option>
                <option value="false">Disable</option>
            </select><br>           
            Gender: <select id="slGender" name="gender">
                <option value="true">Male</option>
                <option value="false">Female</option>
            </select><br>
            <input type="submit" value="Submit" name="Submit" />
        </form>
        <script type="text/javascript">
 
            $(document).ready(()=>{
                $("#slStatus").val(${pat.status}.toString());
                $("#slGender").val(${pat.account.getGender()}.toString());
            }); 
        </script>
    </body>

</html>
