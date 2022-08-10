/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAL.DAO;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Report {
    private int reportID;
    private Doctor doctor;
    private Patient patient;
    private String description;
    private String detail;
    private String startDate;
    private String endDate;
    private Boolean status;

    DAO dao = new DAO();
    
    public Report() {
    }

    public Report(int reportID, int doctorID, int patientID) {
        this.reportID = reportID;
        this.doctor = dao.getDoctorByID(doctorID);
        this.patient = dao.getPatientByID(doctorID);
    }

    public Report(int reportID, int doctorID, int patientID, String description, String detail, String startDate, String endDate, Boolean status) {
        this.reportID = reportID;
        this.doctor = dao.getDoctorByID(doctorID);
        this.patient = dao.getPatientByID(doctorID);
        this.description = description;
        this.detail = detail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    
    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
