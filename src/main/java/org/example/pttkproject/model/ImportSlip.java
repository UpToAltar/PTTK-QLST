package org.example.pttkproject.model;

import java.sql.Date;

public class ImportSlip {
    private String id;
    private Date date;
    private float totalPrice;
    private String tblSupplierId;
    private String tblWarehouseStaffId;

    public ImportSlip() {
    }

    public ImportSlip(String id, Date date, float totalPrice, String tblSupplierId, String tblWarehouseStaffId) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.tblSupplierId = tblSupplierId;
        this.tblWarehouseStaffId = tblWarehouseStaffId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTblSupplierId() {
        return tblSupplierId;
    }

    public void setTblSupplierId(String tblSupplierId) {
        this.tblSupplierId = tblSupplierId;
    }

    public String getTblWarehouseStaffId() {
        return tblWarehouseStaffId;
    }

    public void setTblWarehouseStaffId(String tblWarehouseStaffId) {
        this.tblWarehouseStaffId = tblWarehouseStaffId;
    }
}

