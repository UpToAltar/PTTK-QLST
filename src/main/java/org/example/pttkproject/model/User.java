package org.example.pttkproject.Model;

import java.sql.Date;

public class User {
    private String id;
    private String fullName;
    private String userName;
    private String password;
    private Date birthDay;
    private String address;
    private String email;
    private String phone;
    private String role;
    private String note;

    public User() {
    }

    public User(String id, String fullName, String userName, String password, Date birthDay, String address, String email, String phone, String role, String note) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.birthDay = birthDay;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
