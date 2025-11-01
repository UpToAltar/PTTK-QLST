package org.example.pttkproject.DAO;

import org.example.pttkproject.Model.Customer;
import org.example.pttkproject.Model.WarehouseStaff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO {
    
    public UserDAO() {
        super();
    }

    public Object login(String username, String password) {
        try {
            String sql = "SELECT * FROM tblUser WHERE userName = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String role = rs.getString("role");
                String userId = rs.getString("id");
                
                if ("Khách hàng".equals(role)) {
                    Customer customer = new Customer();
                    customer.setUserId(userId);
                    customer.setFullName(rs.getString("fullName"));
                    customer.setUserName(rs.getString("userName"));
                    customer.setPassword(rs.getString("password"));
                    customer.setBirthDay(rs.getDate("birthDay"));
                    customer.setAddress(rs.getString("address"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setRole(role);
                    customer.setNote(rs.getString("note"));
                    
                    String customerSql = "SELECT id FROM tblCustomer WHERE tblUserId = ?";
                    PreparedStatement customerPs = con.prepareStatement(customerSql);
                    customerPs.setString(1, userId);
                    ResultSet customerRs = customerPs.executeQuery();
                    
                    if (customerRs.next()) {
                        customer.setId(customerRs.getString("id"));
                    }
                    
                    return customer;
                    
                } else if ("Nhân viên kho".equals(role)) {
                    WarehouseStaff staff = new WarehouseStaff();
                    staff.setUserId(userId);
                    staff.setFullName(rs.getString("fullName"));
                    staff.setUserName(rs.getString("userName"));
                    staff.setPassword(rs.getString("password"));
                    staff.setBirthDay(rs.getDate("birthDay"));
                    staff.setAddress(rs.getString("address"));
                    staff.setEmail(rs.getString("email"));
                    staff.setPhone(rs.getString("phone"));
                    staff.setRole(role);
                    staff.setNote(rs.getString("note"));
                    
                    String staffSql = "SELECT s.id, s.position FROM tblStaff s WHERE s.tblUserId = ?";
                    PreparedStatement staffPs = con.prepareStatement(staffSql);
                    staffPs.setString(1, userId);
                    ResultSet staffRs = staffPs.executeQuery();
                    
                    if (staffRs.next()) {
                        staff.setStaffId(staffRs.getString("id"));
                        staff.setPosition(staffRs.getString("position"));
                        
                        String warehouseSql = "SELECT id FROM tblWarehouseStaff WHERE tblStaffId = ?";
                        PreparedStatement warehousePs = con.prepareStatement(warehouseSql);
                        warehousePs.setString(1, staff.getStaffId());
                        ResultSet warehouseRs = warehousePs.executeQuery();
                        
                        if (warehouseRs.next()) {
                            staff.setId(warehouseRs.getString("id"));
                        }
                    }
                    
                    return staff;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}

