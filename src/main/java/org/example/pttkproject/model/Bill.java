package org.example.pttkproject.Model;

import java.sql.Date;

public class Bill {
    private String id;
    private Date date;
    private double totalPrice;
    private String paymentMethod;
    private String tblSaleStaffId;
    private String tblCustomerId;

    public Bill() {
    }

    public Bill(String id, Date date, double totalPrice, String paymentMethod, String tblSaleStaffId, String tblCustomerId) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.tblSaleStaffId = tblSaleStaffId;
        this.tblCustomerId = tblCustomerId;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTblSaleStaffId() {
        return tblSaleStaffId;
    }

    public void setTblSaleStaffId(String tblSaleStaffId) {
        this.tblSaleStaffId = tblSaleStaffId;
    }

    public String getTblCustomerId() {
        return tblCustomerId;
    }

    public void setTblCustomerId(String tblCustomerId) {
        this.tblCustomerId = tblCustomerId;
    }
}

