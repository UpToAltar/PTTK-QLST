package org.example.pttkproject.Model;

import java.sql.Date;

public class Customer extends User {
    private String id;

    public Customer() {
        super();
    }

    public Customer(String id) {
        super();
        this.id = id;
    }

    public Customer(String id, String userId, String fullName, String userName, String password, Date birthDay, String address, String email, String phone, String role, String note) {
        super(userId, fullName, userName, password, birthDay, address, email, phone, role, note);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return super.getId();
    }

    public void setUserId(String userId) {
        super.setId(userId);
    }

    public String getTblUserId() {
        return getUserId();
    }

    public void setTblUserId(String tblUserId) {
        setUserId(tblUserId);
    }
}
