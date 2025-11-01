package org.example.pttkproject.Model;

public class CartDetail {
    private String id;
    private int quantity;
    private String tblCartId;
    private String tblProductId;
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

