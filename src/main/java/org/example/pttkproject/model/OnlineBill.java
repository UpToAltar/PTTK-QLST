package org.example.pttkproject.Model;

public class OnlineBill {
    private String id;
    private String tblDeliveryStaffId;
    private String tblWarehouseStaffId;
    private String tblOnlineOrderId;

    public OnlineBill() {
    }

    public OnlineBill(String id, String tblDeliveryStaffId, String tblWarehouseStaffId, String tblOnlineOrderId) {
        this.id = id;
        this.tblDeliveryStaffId = tblDeliveryStaffId;
        this.tblWarehouseStaffId = tblWarehouseStaffId;
        this.tblOnlineOrderId = tblOnlineOrderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTblDeliveryStaffId() {
        return tblDeliveryStaffId;
    }

    public void setTblDeliveryStaffId(String tblDeliveryStaffId) {
        this.tblDeliveryStaffId = tblDeliveryStaffId;
    }

    public String getTblWarehouseStaffId() {
        return tblWarehouseStaffId;
    }

    public void setTblWarehouseStaffId(String tblWarehouseStaffId) {
        this.tblWarehouseStaffId = tblWarehouseStaffId;
    }

    public String getTblOnlineOrderId() {
        return tblOnlineOrderId;
    }

    public void setTblOnlineOrderId(String tblOnlineOrderId) {
        this.tblOnlineOrderId = tblOnlineOrderId;
    }
}

