/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Doctor {
    private int doctorid;
    private int classid;
    private User account;
    

    public Doctor() {
    }

    public Doctor(int doctorid, int classid, User account) {
        this.doctorid = doctorid;
        this.classid = classid;
        this.account = account;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Doctor{" + "doctorid=" + doctorid + ", classid=" + classid + ", account=" + account.getAccount() + '}';
    }
    
}
