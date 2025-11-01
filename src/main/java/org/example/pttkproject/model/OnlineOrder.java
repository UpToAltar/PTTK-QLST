package org.example.pttkproject.Model;

import java.sql.Date;

public class OnlineOrder {
    private String id;
    private String status;
    private Date dateTime;
    private double totalPrice;
    private String tblCustomerId;
    private String shipAddress;
    private String receiveName;
    private String phone;

    
    public OnlineOrder() {
    }

    public OnlineOrder(String id, String status, Date dateTime, double totalPrice, String tblCustomerId, String shipAddress, String receiveName, String phone) {
        this.id = id;
        this.status = status;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.tblCustomerId = tblCustomerId;
        this.shipAddress = shipAddress;
        this.receiveName = receiveName;
        this.phone = phone;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTblCustomerId() {
        return tblCustomerId;
    }

    public void setTblCustomerId(String tblCustomerId) {
        this.tblCustomerId = tblCustomerId;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

