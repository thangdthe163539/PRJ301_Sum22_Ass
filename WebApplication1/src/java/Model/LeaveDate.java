/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class LeaveDate {
    private int id;
    private int eid;
    private int dow;
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

    public int getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

   

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
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

    public String getValue() {
        String result = null;
        switch (this.value) {
            case 1:
                result="P";
                break;
            case 2:
                result="KP";
                break;
            case 3:
                result="Ô";
                break;
            case 4:
                result="TS";
                break;
            case 5:
                result="NB";
                break;
            case 6:
                result="TN";
                break;
            case 7:
                result="NL";
                break;
        }
        return result;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
