/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

//import java.util.*;

/**
 *
 * @author Admin
 */
public class WorkDate {
    private int id;
    private Employee employee;
    private int dow; //dayofweek
    private int day;
    private int month;
    private int year;
    private int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }   

    public int getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
