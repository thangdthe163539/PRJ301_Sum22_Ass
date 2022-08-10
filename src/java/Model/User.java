/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class User {
    private String account;
    private String password;
    int role;
    private String firstname;  
    private String lastname;      
    private String dob;
    private String address;
    private String email;
    private String phone;
    private Boolean gender;

    public User() {
    }

    public User(String account, String password, int role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public User(String account, String password, int role, String firstname, String lastname, String dob, String address, String email, String phone, Boolean gender) {
        this.account = account;
        this.password = password;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Account{" + "account=" + account + ", password=" + password + ", role=" + role + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + ", address=" + address + ", email=" + email + ", phone=" + phone + ", gender=" + gender + '}';
    }
    
    
}
