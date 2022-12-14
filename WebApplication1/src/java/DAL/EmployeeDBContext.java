/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Helper.DateTimeHelper;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeDBContext extends DBContext {
    DateTimeHelper dth = new DateTimeHelper();
    
    public Employee getEmployeeById(int eid){
        Employee e = new Employee();
        try {
            String sql = "SELECT e.eid\n" +
                        "      ,e.ename\n" +
                        "      ,e.ecode\n" +
                        "      ,d.dname \n" +
                        "      ,p.pname\n" +
                        "      ,p.coefficients_salary\n" +
                        "  FROM dbo.Employee e left join dbo.Department d on e.did = d.did\n" +
                        "                      left join dbo.Position p on e.pid = p.pid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){                
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setEcode(rs.getLong("ecode"));
                e.setDepartment(rs.getString("dname"));
                e.setPosition(rs.getString("pname"));
                e.setCoefficients_salary(rs.getInt("coefficients_salary"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public ArrayList<WorkDate> getWorkDateByEmployee(int eid){
        ArrayList<WorkDate> workdate = new ArrayList<>();
        try {
            String sql = "SELECT [wid]\n" +
                        "      ,[eid]\n" +
                        "      ,[wdate]\n" +
                        "      ,[value]\n" +
                        "  FROM [WorkDate] WHERE [eid]=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                WorkDate wd = new WorkDate();
                wd.setId(rs.getInt("wid"));
                //wd.setEmployee(this.getEmployeeById(rs.getInt("eid")));
                wd.setEid(rs.getInt("eid"));
                wd.setDow(dth.getDow(rs.getDate("wdate")));
                wd.setDay(dth.getDay(rs.getDate("wdate")));
                wd.setMonth(dth.getMonth(rs.getDate("wdate")));
                wd.setYear(dth.getYear(rs.getDate("wdate")));
                wd.setValue(rs.getInt("value"));
                workdate.add(wd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workdate;
    }
    
    public ArrayList<LeaveDate> getLeaveDateByEmployee(int eid){
        ArrayList<LeaveDate> leavedate = new ArrayList<>();
        try {
            String sql = "SELECT [lid]\n" +
                        "      ,[eid]\n" +
                        "      ,[ldate]\n" +
                        "      ,[value]\n" +
                        "  FROM [LeaveDate] WHERE eid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, eid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                LeaveDate ld = new LeaveDate();
                ld.setId(rs.getInt("lid"));
                //wd.setEmployee(this.getEmployeeById(rs.getInt("eid")));
                ld.setEid(rs.getInt("eid"));
                ld.setDow(dth.getDow(rs.getDate("ldate")));
                ld.setDay(dth.getDay(rs.getDate("ldate")));
                ld.setMonth(dth.getMonth(rs.getDate("ldate")));
                ld.setYear(dth.getYear(rs.getDate("ldate")));
                ld.setValue(rs.getInt("value"));
                leavedate.add(ld);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leavedate;
    }
    
    public ArrayList<Employee> loadEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT e.eid\n" +
                        "      ,e.ename\n" +
                        "      ,e.ecode\n" +
                        "      ,d.dname\n" +
                        "      ,p.pname\n" +
                        "	  ,p.coefficients_salary\n" +
                        "  FROM [Employee] e left join Department d on d.did = e.did\n" +
                        "	left join Position p on p.pid = e.pid\n" +
                        "	ORDER BY d.dname";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Employee e = new Employee();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setEcode(rs.getLong("ecode"));
                e.setDepartment(rs.getString("dname"));
                e.setPosition(rs.getString("pname"));
                e.setCoefficients_salary(rs.getInt("coefficients_salary"));
                e.setWorkdate(this.getWorkDateByEmployee(e.getId()));
                e.setLeavedate(this.getLeaveDateByEmployee(e.getId()));
                employees.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    public ArrayList<Holiday> getListHoliday(){
        ArrayList<Holiday> holiday = new ArrayList<>();
        try {
            String sql = "SELECT [hid]\n" +
                    "      ,[hname]\n" +
                    "      ,[hdate]\n" +
                    "  FROM [Holiday]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Holiday h = new Holiday();
                h.setId(rs.getInt("hid"));
                h.setDow(dth.getDow(rs.getDate("hdate")));
                h.setDay(dth.getDay(rs.getDate("hdate")));
                h.setMonth(dth.getMonth(rs.getDate("hdate")));
                h.setYear(dth.getYear(rs.getDate("hdate")));
                h.setName(rs.getString("hname"));
                holiday.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return holiday;
    }
    
    public static void main(String[] args) {
        EmployeeDBContext em = new EmployeeDBContext();
        
//        ArrayList<Employee> listE = em.loadEmployees();
////        for (Employee e : listE) {
////            ArrayList<WorkDate> listW = e.getWorkdate();                
////            for (WorkDate w : listW) {
////                System.out.println("Name: "+e.getName()+"\nValue: "+w.getValue());
////            }
////        }
//        
//        ArrayList<WorkDate> listW = em.getWorkDateByEmployee(1);                
//                for (WorkDate w : listW) {
//                    System.out.println("Eid: "+w.getEid()+" | Value: "+w.getValue());
//        }

            ArrayList<Holiday> hlist = em.getListHoliday();
            for (Holiday h : hlist) {
                System.out.println("id: "+h.getId()+",Name: "+h.getName()+",day: "+h.getDay()+",month: "+h.getMonth()+",year: "+h.getYear());
            }
    }
}
