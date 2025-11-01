package org.example.pttkproject.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String id;
    private double totalPrice;
    private String tblCustomerId;
    private List<CartDetail> listCartDetail;

    public Cart() {
        this.listCartDetail = new ArrayList<>();
    }

    public Cart(String id, double totalPrice, String tblCustomerId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.tblCustomerId = tblCustomerId;
        this.listCartDetail = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<CartDetail> getListCartDetail() {
        return listCartDetail;
    }

    public void setListCartDetail(List<CartDetail> listCartDetail) {
        this.listCartDetail = listCartDetail;
    }
}

