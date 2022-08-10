<%-- 
    Document   : loginpage
    Created on : Jul 6, 2022, 10:47:47 PM
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
        <h1>Login Page</h1>
        <form action="loginpage" method="post">
            Account: <input name="acc" type="text" /></br>
            Password: <input name="pass" type="text" /></br> 
            <a href="newpatientpage">Create new account</a></br>
            <input type="submit" value="login" >
        </form>
    </body>
</html>
