package org.example.pttkproject.model;

public class Cart {
    private String id;
    private float totalPrice;
    private String tblCustomerId;

    public Cart() {
    }

    public Cart(String id, float totalPrice, String tblCustomerId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.tblCustomerId = tblCustomerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

