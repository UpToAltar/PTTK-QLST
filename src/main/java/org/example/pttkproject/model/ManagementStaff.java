package org.example.pttkproject.model;

public class ManagementStaff {
    private String id;
    private String tblStaffId;

    public ManagementStaff() {
    }

    public ManagementStaff(String id, String tblStaffId) {
        this.id = id;
        this.tblStaffId = tblStaffId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTblStaffId() {
        return tblStaffId;
    }

    public void setTblStaffId(String tblStaffId) {
        this.tblStaffId = tblStaffId;
    }
}

