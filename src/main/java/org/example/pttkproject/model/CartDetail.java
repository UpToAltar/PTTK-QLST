package org.example.pttkproject.model;

public class CartDetail {
    private String id;
    private int quantity;
    private String tblCartId;
    private String tblProductId;

    public CartDetail() {
    }

    public CartDetail(String id, int quantity, String tblCartId, String tblProductId) {
        this.id = id;
        this.quantity = quantity;
        this.tblCartId = tblCartId;
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

    public String getTblCartId() {
        return tblCartId;
    }

    public void setTblCartId(String tblCartId) {
        this.tblCartId = tblCartId;
    }

    public String getTblProductId() {
        return tblProductId;
    }

    public void setTblProductId(String tblProductId) {
        this.tblProductId = tblProductId;
    }
}

