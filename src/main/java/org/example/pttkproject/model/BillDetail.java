package org.example.pttkproject.Model;

public class BillDetail {
    private String id;
    private int quantity;
    private double price;
    private String tblBillId;
    private String tblProductId;

    public BillDetail() {
    }

    public BillDetail(String id, int quantity, double price, String tblBillId, String tblProductId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.tblBillId = tblBillId;
        this.tblProductId = tblProductId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTblBillId() {
        return tblBillId;
    }

    public void setTblBillId(String tblBillId) {
        this.tblBillId = tblBillId;
    }

    public String getTblProductId() {
        return tblProductId;
    }

    public void setTblProductId(String tblProductId) {
        this.tblProductId = tblProductId;
    }
}

