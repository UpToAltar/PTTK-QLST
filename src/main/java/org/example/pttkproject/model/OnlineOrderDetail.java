package org.example.pttkproject.Model;

public class OnlineOrderDetail {
    private String id;
    private int quantity;
    private double salePrice;
    private String tblOnlineOrderId;
    private String tblProductId;

    public OnlineOrderDetail() {
    }

    public OnlineOrderDetail(String id, int quantity, double salePrice, String tblOnlineOrderId, String tblProductId) {
        this.id = id;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.tblOnlineOrderId = tblOnlineOrderId;
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getTblOnlineOrderId() {
        return tblOnlineOrderId;
    }

    public void setTblOnlineOrderId(String tblOnlineOrderId) {
        this.tblOnlineOrderId = tblOnlineOrderId;
    }

    public String getTblProductId() {
        return tblProductId;
    }

    public void setTblProductId(String tblProductId) {
        this.tblProductId = tblProductId;
    }
}

