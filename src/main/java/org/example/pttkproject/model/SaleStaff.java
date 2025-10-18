package org.example.pttkproject.model;

public class SaleStaff {
    private String id;
    private String tblStaffId;

    public SaleStaff() {
    }

    public SaleStaff(String id, String tblStaffId) {
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

