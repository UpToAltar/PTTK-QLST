package org.example.pttkproject.model;

public class BillDetail {
    private String id;
    private int quantity;
    private float price;
    private String tblBillId;
    private String tblProductId;

    public BillDetail() {
    }

    public BillDetail(String id, int quantity, float price, String tblBillId, String tblProductId) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

