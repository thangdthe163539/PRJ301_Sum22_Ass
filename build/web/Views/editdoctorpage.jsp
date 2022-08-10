<%-- 
    Document   : editdoctorpage
    Created on : Jul 15, 2022, 11:10:16 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="d" class="DAL.DAO"  scope="request"></jsp:useBean> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="editdoctorpage" method="post">  
            <input type="hidden" name="pPage" value="${sessionScope.prePage}">
            <input type="hidden" name="acc" value="${pat.account.getAccount()}"> 
            <input type="hidden" name="doctorid" value="${pat.doctorid}">            
            First name: <input type="text" name="fname" value="${pat.account.getFirstname()}"><br>
            Last name: <input type="text" name="lname" value="${pat.account.getLastname()}"><br>                  
            Date of birth: <input type="date" name="dob" value="${pat.account.getDob()}"><br>
            Address: <input type="text" name="address" value="${pat.account.getAddress()}"><br>
            Email: <input type="text" name="email" value="${pat.account.getEmail()}"><br>
            Phone: <input type="text" name="phone" value="${pat.account.getPhone()}"><br> 
            Class <input type="text" name="doctorclass" value="${d.getClassByID(dt.classid).name}"><br>          
            Gender: <select id="slGender" name="gender">
                <option value="true">Male</option>
                <option value="false">Female</option>
            </select><br>
            <input type="submit" value="Submit" name="Submit" />
        </form>
        <script type="text/javascript">
 
            $(document).ready(()=>{
                $("#slGender").val(${pat.account.getGender()}.toString());
            });
        </script>
    </body>
</html>
