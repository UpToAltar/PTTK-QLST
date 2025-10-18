package org.example.pttkproject.model;

import java.sql.Date;

public class OnlineOrder {
    private String id;
    private String status;
    private Date dateTime;
    private float totalPrice;
    private String tblCustomerId;

    public OnlineOrder() {
    }

    public OnlineOrder(String id, String status, Date dateTime, float totalPrice, String tblCustomerId) {
        this.id = id;
        this.status = status;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.tblCustomerId = tblCustomerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTblCustomerId() {
        return tblCustomerId;
    }

    public void setTblCustomerId(String tblCustomerId) {
        this.tblCustomerId = tblCustomerId;
    }
}

