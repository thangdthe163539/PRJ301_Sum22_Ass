<%-- 
    Document   : EditReport
    Created on : Aug 18, 2022, 6:14:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="ch" class="Helper.ControllerHelper"  scope="request"></jsp:useBean> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Report</title>
    </head>
    <body> 
        <h1>Chỉnh sửa bảng chấm công tháng ${month}</h1> 
           
        <form action="EditReport?${month}-${year}" method="POST">
            Tháng 
            <select name="month">
                <option value="1" ${month==1?"selected":""}>1</option>
                <option value="2" ${month==2?"selected":""}>2</option>
                <option value="3" ${month==3?"selected":""}>3</option>
                <option value="4" ${month==4?"selected":""}>4</option>
                <option value="5" ${month==5?"selected":""}>5</option>
                <option value="6" ${month==6?"selected":""}>6</option>
                <option value="7" ${month==7?"selected":""}>7</option>
                <option value="8" ${month==8?"selected":""}>8</option>
                <option value="9" ${month==9?"selected":""}>9</option>
                <option value="10" ${month==10?"selected":""}>10</option>
                <option value="11" ${month==11?"selected":""}>11</option>
                <option value="12" ${month==12?"selected":""}>12</option>
            </select>
             Năm 
             <input type="text" name="year" value="${year}">
            <input type="submit">
        </form>
      
        
        <table border="1px solid">
            <tr>
                <td>MaNV</td>
                <td>Ho Ten</td>                
                <td>Bo Phan</td>
                <td>Chuc Vu</td>
                <c:forEach var="d" items="${requestScope.listDay}">
                    <td>${d}</td>
                </c:forEach>
            </tr>
            <c:forEach var="em" items="${requestScope.employees}" >
                <tr>
                    <td>${em.ecode}</td>
                    <td>${em.name}</td>                    
                    <td>${em.department}</td>
                    <td>${em.position}</td>
                    <c:forEach var="d" items="${requestScope.listDay}">
                        <td>
                            <c:forEach items="${em.workdate}" var="wd">
                                <c:if test="${ch.getDay(d) eq wd.day and em.id eq wd.eid and wd.month eq month and wd.year eq year}">
                                    ${wd.value}
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>   
            </c:forEach>
        </table>
    </body>
</html>
