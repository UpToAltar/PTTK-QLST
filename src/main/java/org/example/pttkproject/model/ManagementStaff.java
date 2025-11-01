package org.example.pttkproject.Model;

import java.sql.Date;

public class ManagementStaff extends Staff {
    private String id;

    public ManagementStaff() {
        super();
    }

    public ManagementStaff(String id) {
        super();
        this.id = id;
    }

    public ManagementStaff(String id, String staffId, String position) {
        super(staffId, position);
        this.id = id;
    }

    public ManagementStaff(String id, String staffId, String position, String userId, String fullName, String userName, String password, Date birthDay, String address, String email, String phone, String role, String note) {
        super(staffId, position, userId, fullName, userName, password, birthDay, address, email, phone, role, note);
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

    public String getStaffId() {
        return super.getId();
    }

    public void setStaffId(String staffId) {
        super.setId(staffId);
    }
}

