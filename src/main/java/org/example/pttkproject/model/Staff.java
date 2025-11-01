package org.example.pttkproject.Model;

import java.sql.Date;

public class Staff extends User {
    private String id;
    private String position;

    public Staff() {
        super();
    }

    public Staff(String id, String position) {
        super();
        this.id = id;
        this.position = position;
    }

    public Staff(String id, String position, String userId, String fullName, String userName, String password, Date birthDay, String address, String email, String phone, String role, String note) {
        super(userId, fullName, userName, password, birthDay, address, email, phone, role, note);
        this.id = id;
        this.position = position;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserId() {
        return super.getId();
    }

    public void setUserId(String userId) {
        super.setId(userId);
    }
}
