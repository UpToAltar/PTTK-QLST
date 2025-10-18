package org.example.pttkproject.model;

public class Staff {
    private String id;
    private String position;
    private String tblUserId;

    public Staff() {
    }

    public Staff(String id, String position, String tblUserId) {
        this.id = id;
        this.position = position;
        this.tblUserId = tblUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTblUserId() {
        return tblUserId;
    }

    public void setTblUserId(String tblUserId) {
        this.tblUserId = tblUserId;
    }
}
