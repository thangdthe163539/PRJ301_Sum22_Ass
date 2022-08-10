<%-- 
    Document   : newdoctorpage
    Created on : Jul 12, 2022, 11:27:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="newdoctorpage" method="post">
            <input type="hidden" name="pPage" value="${sessionScope.prePage}">
            <input type="hidden" name="doctorid" value="">  
            Account: <input type="text" name="acc" value=""><br>
            Password: <input type="text" name="pass" value=""><br>
            Last name: <input type="text" name="lname" value=""><br>
            First name: <input type="text" name="fname" value=""><br>                  
            Date of birth: <input type="date" name="dob" value=""><br>
            Address: <input type="text" name="address" value=""><br>
            Email: <input type="text" name="email" value=""><br>
            Phone: <input type="text" name="phone" value=""><br> 
            Class: <input type="text" name="doctorclass" value=""><br>           
            Gender: <select id="slGender" name="gender">
                <option value="true">Male</option>
                <option value="false">Female</option>
            </select><br>
            <input type="submit" value="Submit" name="Submit" />
        </form>
    </body>
</html>
