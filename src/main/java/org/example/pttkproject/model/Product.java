package org.example.pttkproject.model;

public class Product {
    private String id;
    private String code;
    private String name;
    private String description;
    private float importPrice;
    private String unit;
    private float salePrice;
    private int quantity;
    private String category;

    public Product() {
    }

    public Product(String id, String code, String name, String description, float importPrice, String unit, float salePrice, int quantity, String category) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.importPrice = importPrice;
        this.unit = unit;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
