package org.example.pttkproject.DAO;

import org.example.pttkproject.Model.Cart;
import org.example.pttkproject.Model.CartDetail;
import org.example.pttkproject.Model.Customer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class OrderOnlineDAO extends DAO {
    
    public OrderOnlineDAO() {
        super();
    }

    public boolean createOrder(Customer customer, Cart cart) {
        try {
            if (customer == null || customer.getId() == null || cart == null || cart.getListCartDetail() == null || cart.getListCartDetail().isEmpty()) {
                return false;
            }
            
            String orderId = UUID.randomUUID().toString();
            
            String orderSql = "INSERT INTO tblOnlineOrder (id, status, dateTime, totalPrice, tblCustomerId, shipAddress, receiveName, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement orderPs = con.prepareStatement(orderSql);
            orderPs.setString(1, orderId);
            orderPs.setString(2, "Đang xử lý");
            orderPs.setDate(3, new Date(System.currentTimeMillis()));
            orderPs.setDouble(4, cart.getTotalPrice());
            orderPs.setString(5, customer.getId());
            orderPs.setString(6, customer.getAddress());
            orderPs.setString(7, customer.getFullName());
            orderPs.setString(8, customer.getPhone());
            orderPs.executeUpdate();

            for (CartDetail cartDetail : cart.getListCartDetail()) {
                String detailId = UUID.randomUUID().toString();
                
                String detailSql = "INSERT INTO tblOnlineOrderDetail (id, quantity, salePrice, tblOnlineOrderId, tblProductId) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement detailPs = con.prepareStatement(detailSql);
                detailPs.setString(1, detailId);
                detailPs.setInt(2, cartDetail.getQuantity());
                detailPs.setDouble(3, cartDetail.getProduct().getSalePrice());
                detailPs.setString(4, orderId);
                detailPs.setString(5, cartDetail.getProduct().getId());
                detailPs.executeUpdate();
            }

            CartDAO cartDAO = new CartDAO();
            cartDAO.clearCart();
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}

