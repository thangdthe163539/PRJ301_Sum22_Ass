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
        <jsp:useBean id="ch" class="Helper.ControllerHelper"  scope="request"></jsp:useBean> 
        <jsp:useBean id="dh" class="Helper.DateTimeHelper"  scope="request"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="../Css/report.css" rel="stylesheet" type="text/css"/>
            <style>
                body{
                    overflow: scroll;
                }

                h1{
                    width: 100%;
                    margin: 30px;
                    text-align: center;
                }
                
                table td{
                    text-align: center;
                }
                
                .sun{
                    background-color: #99ccff;
                }
                .sat{
                    background-color: #ffff99;
                }
                .holiday{
                    background-color: #ff9999;
                }
                
                .green{
                    background-color: #ccffcc;
                }
                
                #rtable{
                    width: 100%;
                    display: block;
                }
                
                #rtable table{
                    padding-top: 70px;
                    float: right;
                }
                
                #rtable p{
                    float: left;
                }
                
                #rtable table td{
                    border: 1px solid;
                }
                
                #h1 {
                    padding-top: 120px;
                    width: 100%;
                    display: block;
                }
                
                #des{
                    float: right;
                }
                #des table {
                    border: 1px solid;
                }
                #des table td{
                    border: 1px solid;
                }
            </style>
            <title>Working Time Report</title>
        </head>
        <body> 
            <div id="rtable">
                <p>TRUNG TÂM TIN HỌC SAO VIỆT<br>
                    SĐT: <b>093.11.44.585</b><br>
                    Website: <a href="blogdaytinhoc.com">blogdaytinhoc.com</a>
                </p>
                <table>
                    <tr>
                        <td style="width:55px"><b>Tháng</b></td>
                        <td class="green" style="width:20px">${month}</td>
                        <td style="width:87px">Số ngày CHỦ NHẬT</td>
                        <td class="sun" style="width:20px">${dh.countSunOfMonth(month, year)}</td>
                        <td style="width:87px">Số ngày THỨ BẢY</td>
                        <td class="sat" style="width:20px">${dh.countSatOfMonth(month, year)}</td>
                    </tr>
                </table>            
            </div>
                    
            <div id="h1">
                <h1>Bảng chấm công tháng ${month}</h1> 
            </div>

            <div id="des">
                <table>                   
                    <tr>
                        <td class="sat"></td>
                        <td class="sun"></td>
                        <td class="holiday"></td>
                        <td>P</td>
                        <td>KP</td>
                    </tr>
                    <tr>
                        <td>T7</td>
                        <td>CN</td>
                        <td>Ngày Lễ</td>
                        <td>Có phép</td>
                        <td>Không phép</td>
                    </tr>
                    <tr >
                        <td>NB</td>
                        <td>Ô</td>
                        <td>TS</td>
                        <td>TN</td>
                        <td>NL</td>
                    </tr>
                    <tr>
                        <td>Nghỉ bù</td>
                        <td>Nghỉ ốm</td>
                        <td>Thai sản</td>
                        <td>Tai nạn</td>
                        <td>Nghỉ lễ</td>
                    </tr>
                </table>            
            </div>   
            
            <div style="margin-top: 100px;">      
                <form action="WorkingTimeReport?${month}-${year}" method="POST">
                    <input type="month" name="month-year" value="${ym}">
                    <input type="submit">
                </form>
            </div>  

            <table border="1px solid" style="width: 160%">
                <tr>
                    <td style="width: 60px">Mã NV</td>
                    <td style="width: 120px">Họ và Tên</td>                
                    <td style="width: 100px">Bộ Phận</td>
                    <td style="width: 100px">Chức Vụ</td>
                    <td style="width: 40px">Nghỉ có phép</td>
                    <td style="width: 50px">Nghỉ không phép</td>
                    <td style="width: 50px">Công thường</td>
                    <td style="width: 45px">Công CN</td>
                    <td class="green" style="width: 60px">Tổng công</td>
                    <c:forEach var="d" items="${requestScope.listDay}">
                        <td style="width: 40px" <c:choose>
                                <c:when test="${dh.checkSat(d) and !dh.checkHoliday(d, month, year)}">
                                    class="sat"
                                </c:when>
                                <c:when test="${dh.checkSun(d) and !dh.checkHoliday(d, month, year)}">
                                    class="sun"
                                </c:when>
                                <c:when test="${dh.checkHoliday(d, month, year)}">
                                    class="holiday"
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                            <c:forEach items="${requestScope.listHoli}" var="ho">
                                <c:if test="${ch.getDay(d) eq ho.day and ho.month eq month and ho.year eq year}">title="${ho.name}"</c:if>
                            </c:forEach>            
                            >${d}</td>
                    </c:forEach>
                </tr>
                <c:forEach var="em" items="${requestScope.employees}" >
                    <tr>
                        <td>${em.ecode}</td>
                        <td>${em.name}</td>                    
                        <td>${em.department}</td>
                        <td>${em.position}</td>
                        <td>${ch.totalLeaveDateHasPer(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalLeaveDateNoPer(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.countNorWorkDate(em.workdate, month, year, em.id)}</td>
                        <td>${ch.countSunWorkDate(em.workdate, month, year, em.id)}</td> 
                        <td class="green">${ch.countNorWorkDate(em.workdate, month, year, em.id)+ch.countSunWorkDate(em.workdate, month, year, em.id)}</td>
                        <c:forEach var="d" items="${requestScope.listDay}">
                            <td <c:choose>
                                    <c:when test="${dh.checkSat(d) and !dh.checkHoliday(d, month, year)}">
                                        class="sat"
                                    </c:when>
                                    <c:when test="${dh.checkSun(d) and !dh.checkHoliday(d, month, year)}">
                                        class="sun"
                                    </c:when>
                                    <c:when test="${dh.checkHoliday(d, month, year)}">
                                        class="holiday"
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                </c:choose>
                                <c:forEach items="${requestScope.listHoli}" var="ho">
                                    <c:if test="${ch.getDay(d) eq ho.day and ho.month eq month and ho.year eq year}">title="${ho.name}"</c:if>
                                </c:forEach>   
                                >
                                <c:choose>
                                    <c:when test="${dh.checkHoliday(d, month, year)}">
                                        NL
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${em.workdate}" var="wd">
                                            <c:if test="${ch.getDay(d) eq wd.day and em.id eq wd.eid and wd.month eq month and wd.year eq year}">
                                                ${wd.getValue()}
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach items="${em.leavedate}" var="ld">
                                            <c:if test="${ch.getDay(d) eq ld.day and em.id eq ld.eid and ld.month eq month and ld.year eq year}">
                                                ${ld.getValue()}
                                            </c:if>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </c:forEach>
                    </tr>   
                </c:forEach>
            </table>
            <c:if test="${dh.checkCurDay(month, year)}">
                <a href="SalaryReport?${month}-${year}">Xem bảng lương</a> 
            </c:if>       
            
    </body>
</html>
