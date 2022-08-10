/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Patient {
    private int patientid;
    private Boolean status;
    private User account;

    public Patient() {
    }

    public Patient(int patientid, Boolean status, User account) {
        this.patientid = patientid;
        this.status = status;
        this.account = account;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientid=" + patientid + ", status=" + status + ", account=" + account.getAccount() + '}';
    }

    
    
}
