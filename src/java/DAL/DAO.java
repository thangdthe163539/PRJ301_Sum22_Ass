/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.util.ArrayList;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author PiPi
 */
public class DAO {

    private Connection con;
    private String status = "";
    
    //private ArrayList<Patient> patientList;
    //private ArrayList<Record> recordList;
    //private HashMap<String, Department> departHm;

    public String getStatus() {
        return status;
    }

    public DAO() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            status = "Error Connection" + e.getMessage();
        }
    }

    public ArrayList<DoctorClass> loadClass(){
        String sql = "Select * from Class";
        ArrayList<DoctorClass> ar = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);            
                ar.add(new DoctorClass(id,name));
            }
        } catch (Exception e) {
        }
        return ar;
    }
    
    public DoctorClass getClassByID(int id){
        ArrayList<DoctorClass> cList = this.loadClass();
        try {
            for (DoctorClass dclass : cList) {
                if(dclass.getClassid()== id) return dclass;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");    
        }
        return null;
    }
    
    public ArrayList<User> getListUser(){
        String sql = "Select * from [User]";
        ArrayList<User> ar = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String account = rs.getString(1);
                String pass = rs.getString(2);
                int role = rs.getInt(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String dob = rs.getString(6);
                String address = rs.getString(7);
                String phone = rs.getString(8);
                String email = rs.getString(9);
                Boolean gender = rs.getBoolean(10);                
                ar.add(new User(account, pass, role, firstname, lastname, dob, address, email, phone, gender));
            }
        } catch (Exception e) {
        }
        return ar;
    }
    
    public ArrayList<Doctor> loadDoctor() {
        
        String sql = "select * from Doctor";
        ArrayList<Doctor> doctorList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);                
                int doctorClass = rs.getInt(2);
                User account = this.getUserByAcc(rs.getString(3));
                doctorList.add(new Doctor(id, doctorClass, account));
            }
        } catch (Exception e) {
            //status = "Error at read student" + e.getMessage();
        }
        return doctorList;
    }
    
    public ArrayList<Patient> loadPatient() {
        String sql = "select * from Patient";
        ArrayList<Patient> patientList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Boolean statusP = rs.getBoolean(2);
                User account = this.getUserByAcc(rs.getString(3));
                patientList.add(new Patient(id, statusP, account));
            }
            return patientList; 
        } catch (Exception e) {
            //status = "Error at read student" + e.getMessage();
        }
        return null;
    }
    
    public ArrayList<Report> loadReport(){
        String sql = "select * from Report";
        ArrayList<Report> recordList = new ArrayList<>();
        try {            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int recordID = rs.getInt(1);
                int patientID = rs.getInt(2);
                int doctorID = rs.getInt(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String startDate = rs.getString(6);
                String endDate = rs.getString(7);
                Boolean statusR = rs.getBoolean(8);
                recordList.add(new Report(recordID,doctorID,patientID,description,detail,startDate,endDate,statusR));
            }
            //return patientList; 
        } catch (Exception e) {
            //status = "Error at read student" + e.getMessage();
        }
        return recordList;
    }
    public ArrayList<Report> loadReportByPatient(int pID){
        String sql = "select * from Report where PatientID =?";
        ArrayList<Report> recordList = new ArrayList<>();
        try {            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int recordID = rs.getInt(1);
                int patientID = rs.getInt(2);
                int doctorID = rs.getInt(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String startDate = rs.getString(6);
                String endDate = rs.getString(7);
                Boolean statusR = rs.getBoolean(8);
                recordList.add(new Report(recordID,doctorID,patientID,description,detail,startDate,endDate,statusR));
            }
            //return patientList; 
        } catch (Exception e) {
            status = "Error at read student" + e.getMessage();
        }
        return recordList;
    }
    
    public ArrayList<Report> loadReportByDoctor(int dID){
        String sql = "select * from Report where DoctorID =?";
        ArrayList<Report> recordList = new ArrayList<>();
        try {            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int recordID = rs.getInt(1);
                int patientID = rs.getInt(2);
                int doctorID = rs.getInt(3);
                String description = rs.getString(4);
                String detail = rs.getString(5);
                String startDate = rs.getString(6);
                String endDate = rs.getString(7);
                Boolean statusR = rs.getBoolean(8);
                recordList.add(new Report(recordID,doctorID,patientID,description,detail,startDate,endDate,statusR));
            }
            //return patientList; 
        } catch (Exception e) {
            status = "Error at read student" + e.getMessage();
        }
        return recordList;
    }

    //
    public void insertPatient(String lastname, String firstname, String dob, String address, String email, String phone, Boolean status, Boolean gender, String account) {
        String sql = "insert into Patient values(?,?,?,?,?,?,?,?,?)";
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            //Date DoB = sdf.parse(dob);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lastname);
            ps.setString(2, firstname);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setBoolean(7, status);
            ps.setBoolean(8, gender);
            ps.setString(9, account);
            ps.execute();

        } catch (Exception e) {
            //status = "Error insert student" + e.getMessage();
        }
    }
    //
    public void insertDoctor(String lastname, String firstname, String dob, String address, String email, String phone, String doctorclass, Boolean gender, String account) {
        String sql = "insert into Doctor values(?,?,?,?,?,?,?,?,?)";
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        try {
            //Date DoB = sdf.parse(dob);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lastname);
            ps.setString(2, firstname);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, doctorclass);
            ps.setBoolean(8, gender);
            ps.setString(9, account);
            ps.execute();

        } catch (Exception e) {
            status = "Error insert student" + e.getMessage();
        }
    }
    //, String DoB, String email, String phone, String address, String status, Boolean gender
    public void insertUser(String acc, String pass, int role){
        String sql = "insert into User values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);
            ps.setInt(3, role);
            ps.execute();
        } catch (Exception e) {
            status = "Error insert student" + e.getMessage();
        }
    }

    public void updatePatient(int patientid, String lastname, String firstname, String dob, String address, String email, String phone, Boolean status, Boolean gender) {
        String sql = "update User set LastName =?, FirstName =?, DoB =?," + "Address =?, Email =?, Phone =?, Status =?, Gender =? where PatientID =?";
        ///SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //Date DoB = sdf.parse(dob);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lastname);
            ps.setString(2, firstname);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setBoolean(7, status);
            ps.setBoolean(8, gender);
            ps.setInt(9, patientid);
            ps.execute();
        } catch (Exception e) {
            //status = "Error at Update Student" + e.getMessage();
        }
    }
    
    public void updateDoctor(String account, String lastname, String firstname, String dob, String address, String email, String phone, String doctorclass, Boolean gender) {
        String sql = "update User set LastName =?, FirstName =?, DoB =?," + "Address =?, Email =?, Phone =?, Gender =? where Account =?";
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            //Date DoB = sdf.parse(dob);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lastname);
            ps.setString(2, firstname);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setBoolean(7, gender);
            ps.setString(8, account);
            ps.execute();
        } catch (Exception e) {
            //status = "Error at Update Student" + e.getMessage();
        }
    }
    
    public void updateRecord(int recordid, String description, String detail, String startdate, String enddate) {
        String sql = "update Record set Description =?, Detail =?, StartDate =?, EndDate =?, Status =? where RecordID =?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
//            Date startDate = sdf.parse(startdate);
            Date endDate = sdf.parse(enddate);
            Date now = sdf.parse(LocalDateTime.now().toString());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, description);
            ps.setString(2, detail);
            ps.setString(3, startdate);
            ps.setString(4, enddate);
            if(now.after(endDate)){
                ps.setBoolean(5, false);
            }else{
                ps.setBoolean(5, true);
            }
            ps.setInt(6, recordid);
            ps.execute();
        } catch (Exception e) {
            //status = "Error at Update Student" + e.getMessage();
        }
    }
    
    public void delDoctor(int id) {
        String sql = "delete from Doctor where DoctorID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            status = "Error at delete student " + e.getMessage();
        }
    }

    public void delPatient(int id) {
        String sql = "delete from Patient where PatientID =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            status = "Error at delete student " + e.getMessage();
        }
    }
    
    public Patient getPatientByID(int id){
        ArrayList<Patient> pList = this.loadPatient();
        try {
            for (Patient patient : pList) {
                if(patient.getPatientid()== id) return patient;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");    
        }
        return null;
    }
    
    public Patient getPatientByAcc(String acc){
        ArrayList<Patient> pList = this.loadPatient();
        try {
            for (Patient patient : pList) {
                if(patient.getAccount().equals(acc)) return patient;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");    
        }
        return null;
    }
    
    public Doctor getDoctorByAcc(String acc){
        ArrayList<Doctor> dList = this.loadDoctor();
        try {
            for (Doctor doctor : dList) {
                if(doctor.getAccount().equals(acc)) return doctor;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");
        }
        return null;
    }
    
    public Doctor getDoctorByID(int id){
        ArrayList<Doctor> dList = this.loadDoctor();
        try {
            for (Doctor doctor : dList) {
                if(doctor.getDoctorid()==id) return doctor;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");
        }
        return null;
    }
    
    public Report getRecordByID(int id){
        ArrayList<Report> rList = this.loadReport();
        try {
            for (Report record : rList) {
                if(record.getReportID()==id) return record;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");
        }
        return null;
    }
    
    public User getUserByAcc(String acc){
        ArrayList<User> aList = this.getListUser();
        try {
            for (User account : aList) {
                if(account.getAccount().equals(acc)) return account;
            }
            //System.out.println("ok");
        } catch (Exception e) {        
            //System.out.println("loi");
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
//        ArrayList<Doctor> dList = dao.loadDoctor();
//        for (Doctor doctor : dList) {
//            System.out.println(doctor.toString());
//        }
//        ArrayList<Patient> pList = dao.loadPatient();
//        for (Patient patient : pList) {
//            System.out.println(patient.toString());
//        }
        ArrayList<Report> rList = dao.loadReportByDoctor(dao.getDoctorByAcc("doctor1").getDoctorid());
        for (Report report : rList) {
            System.out.println(report.toString());
        }
        
    }
}
