/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Employee {
    private int id;
    private String name;
    private long ecode;
    private String department;
    private String position;
    private int coefficients_salary;
    
    private ArrayList<WorkDate> workdate = new ArrayList();
    private ArrayList<LeaveDate> leavedate = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEcode() {
        return ecode;
    }

    public void setEcode(long ecode) {
        this.ecode = ecode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCoefficients_salary() {
        return coefficients_salary;
    }

    public void setCoefficients_salary(int coefficients_salary) {
        this.coefficients_salary = coefficients_salary;
    }

    public ArrayList<WorkDate> getWorkdate() {
        return workdate;
    }

    public void setWorkdate(ArrayList<WorkDate> workdate) {
        this.workdate = workdate;
    }

    public ArrayList<LeaveDate> getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(ArrayList<LeaveDate> leavedate) {
        this.leavedate = leavedate;
    }
    
    
}
