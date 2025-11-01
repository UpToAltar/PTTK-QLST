package org.example.pttkproject.Model;

import java.sql.Date;

public class ImportSlip {
    private String id;
    private Date date;
    private double totalPrice;
    private String tblSupplierId;
    private String tblWarehouseStaffId;

    public ImportSlip() {
    }

    public ImportSlip(String id, Date date, double totalPrice, String tblSupplierId, String tblWarehouseStaffId) {
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

