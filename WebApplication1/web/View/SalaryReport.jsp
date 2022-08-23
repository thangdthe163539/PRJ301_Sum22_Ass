<%-- 
    Document   : SalaryReport
    Created on : Aug 23, 2022, 1:49:03 AM
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
        <title>JSP Page</title>
        <style>
            table{
                text-align: center;
            }
            
            h1{
                margin: 40px;
                text-align: center;
            }
            .red{
                background-color: #ffcccc;
            }
            .blue{
                background-color: #ccffff;
            }
            .yellow{
                background-color: #ffff99;
            }
            .green{
                background-color: #99ff99;
            }
        </style>
    </head>
    <body>
        <p>TRUNG TÂM TIN HỌC SAO VIỆT<br>
                    SĐT: <b>093.11.44.585</b><br>
                    Website: <a href="blogdaytinhoc.com">blogdaytinhoc.com</a>
        </p>
        <h1>Bảng lương tháng ${month} năm ${year}</h1>
        <table border="1px solid">
            <tr>
                <td style="width: 60px" rowspan="2">Mã NV</td>
                <td style="width: 120px" rowspan="2">Họ và Tên</td>                
                <td style="width: 100px" rowspan="2">Bộ Phận</td>
                <td style="width: 100px" rowspan="2">Chức Vụ</td>                
                <td class="red" colspan="8">Các ngày nghỉ</td>
                <td class="yellow" rowspan="2" style=" width: 80px">Lương cơ bản</td>                 
                <td class="red" colspan="4">Ngày công</td>                               
                <td class="red" colspan="3">Bảo hiểm</td>
                <td class="yellow" rowspan="2" style=" width: 80px">Lương thực tế</td>
            </tr>
            <tr>
                <td>Nghỉ bù</td>
                <td>Nghỉ ốm</td>
                <td>Thai sản</td>
                <td>Tai nạn</td>
                <td>Nghỉ lễ</td>
                <td>Có phép</td>
                <td>Tổng nghỉ có phép</td>
                <td>Tổng nghỉ không phép</td>
                <td class="blue" style="width: 50px">Công thường</td>
                <td class="blue" style="width: 45px">Công CN</td>
                <td class="blue" style="width: 60px">Tổng lương thường</td>
                <td class="blue">Tổng lương CN</td>
                <td class="green">BHXH (8%)</td>
                <td class="green">BHYT (1.5%)</td>
                <td class="green">BHTN (1%)</td>
            </tr>
                <c:forEach var="em" items="${requestScope.employees}" >
                    <tr>
                        <td>${em.ecode}</td>
                        <td>${em.name}</td>                    
                        <td>${em.department}</td>
                        <td>${em.position}</td>
                        <td>${ch.totalNB(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalNO(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalTS(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalTN(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalNL(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalCP(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalLeaveDateHasPer(em.leavedate, month, year, em.id)}</td>
                        <td>${ch.totalLeaveDateNoPer(em.leavedate, month, year, em.id)}</td>
                        <td class="yellow">${ch.roundSalary(em.coefficients_salary * 4420000)}</td>
                        <td class="blue">${ch.countNorWorkDate(em.workdate, month, year, em.id)}</td>
                        <td class="blue">${ch.countSunWorkDate(em.workdate, month, year, em.id)}</td>
                        <td class="blue">${ch.roundSalary(((em.coefficients_salary * 4420000)/dh.totalDayofMonth(month, year))*ch.countNorWorkDate(em.workdate, month, year, em.id))}</td>
                        <td class="blue">${ch.roundSalary(((em.coefficients_salary * 4420000)/dh.totalDayofMonth(month, year))*ch.countSunWorkDate(em.workdate, month, year, em.id)*1.5)}</td>
                        <td class="green">${ch.roundSalary(((em.coefficients_salary * 4420000))*8/100)}</td>
                        <td class="green">${ch.roundSalary(((em.coefficients_salary * 4420000))*1.5/100)}</td>
                        <td class="green">${ch.roundSalary(((em.coefficients_salary * 4420000))/100)}</td>
                        <td class="yellow">${ch.roundSalary(((em.coefficients_salary * 4420000)/dh.totalDayofMonth(month, year))*ch.countNorWorkDate(em.workdate, month, year, em.id))
                            +ch.roundSalary(((em.coefficients_salary * 4420000)/dh.totalDayofMonth(month, year))*ch.countSunWorkDate(em.workdate, month, year, em.id)*1.5)
                            -ch.roundSalary(((em.coefficients_salary * 4420000))*8/100)
                            -ch.roundSalary(((em.coefficients_salary * 4420000))*1.5/100)
                            -ch.roundSalary(((em.coefficients_salary * 4420000))/100)}</td>
                    </tr>
                </c:forEach>
        </table>
        <a href="WorkingTimeReport?${month}-${year}">Bảng chấm công</a>
        <p style="float: right">Đơn vị: VNĐ</p>
    </body>
</html>
