package org.example.pttkproject.model;

public class ImportSlipDetail {
    private String id;
    private int quantity;
    private float price;
    private String tblImportSlipId;
    private String tblProductId;

    public ImportSlipDetail() {
    }

    public ImportSlipDetail(String id, int quantity, float price, String tblImportSlipId, String tblProductId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.tblImportSlipId = tblImportSlipId;
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

    public String getTblImportSlipId() {
        return tblImportSlipId;
    }

    public void setTblImportSlipId(String tblImportSlipId) {
        this.tblImportSlipId = tblImportSlipId;
    }

    public String getTblProductId() {
        return tblProductId;
    }

    public void setTblProductId(String tblProductId) {
        this.tblProductId = tblProductId;
    }
}

