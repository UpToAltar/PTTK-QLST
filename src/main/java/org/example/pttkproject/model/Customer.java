package org.example.pttkproject.model;

public class Customer {
    private String id;
    private String tblUserId;

    public Customer() {
    }

    public Customer(String id, String tblUserId) {
        this.id = id;
        this.tblUserId = tblUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTblUserId() {
        return tblUserId;
    }

    public void setTblUserId(String tblUserId) {
        this.tblUserId = tblUserId;
    }
}
