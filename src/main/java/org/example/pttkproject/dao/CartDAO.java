package org.example.pttkproject.DAO;

import org.example.pttkproject.Model.Cart;
import org.example.pttkproject.Model.CartDetail;
import org.example.pttkproject.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDAO extends DAO {
    
    public CartDAO() {
        super();
    }

    public void addProductToCart(Product product, int quantity) {
        try {
            String cartId = null;
            
            String getCartSql = "SELECT id FROM tblCart WHERE tblCustomerId IS NULL";
            PreparedStatement getCartPs = con.prepareStatement(getCartSql);
            ResultSet cartRs = getCartPs.executeQuery();
            
            if (cartRs.next()) {
                cartId = cartRs.getString("id");
            }
            
            String checkSql = "SELECT * FROM tblCartDetail WHERE tblCartId = ? AND tblProductId = ?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setString(1, cartId);
            checkPs.setString(2, product.getId());
            ResultSet detailRs = checkPs.executeQuery();
            
            if (detailRs.next()) {
                int currentQuantity = detailRs.getInt("quantity");
                String detailId = detailRs.getString("id");
                
                String updateDetailSql = "UPDATE tblCartDetail SET quantity = ? WHERE id = ?";
                PreparedStatement updateDetailPs = con.prepareStatement(updateDetailSql);
                updateDetailPs.setInt(1, currentQuantity + quantity);
                updateDetailPs.setString(2, detailId);
                updateDetailPs.executeUpdate();
            } else {
                String insertDetailSql = "INSERT INTO tblCartDetail (id, quantity, tblCartId, tblProductId) VALUES (UUID(), ?, ?, ?)";
                PreparedStatement insertDetailPs = con.prepareStatement(insertDetailSql);
                insertDetailPs.setInt(1, quantity);
                insertDetailPs.setString(2, cartId);
                insertDetailPs.setString(3, product.getId());
                insertDetailPs.executeUpdate();
            }
            
            String totalSql = "SELECT SUM(cd.quantity * p.salePrice) as total " +
                             "FROM tblCartDetail cd " +
                             "JOIN tblProduct p ON cd.tblProductId = p.id " +
                             "WHERE cd.tblCartId = ?";
            PreparedStatement totalPs = con.prepareStatement(totalSql);
            totalPs.setString(1, cartId);
            ResultSet totalRs = totalPs.executeQuery();
            
            double total = 0;
            if (totalRs.next()) {
                total = totalRs.getDouble("total");
            }
            
            String updateCartSql = "UPDATE tblCart SET totalPrice = ? WHERE id = ?";
            PreparedStatement updateCartPs = con.prepareStatement(updateCartSql);
            updateCartPs.setDouble(1, total);
            updateCartPs.setString(2, cartId);
            updateCartPs.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cart getCart() {
        Cart cart = null;
        
        try {
            String sql = "SELECT * FROM tblCart WHERE tblCustomerId IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setTotalPrice(rs.getDouble("totalPrice"));
                cart.setTblCustomerId(rs.getString("tblCustomerId"));
                
                String cartId = cart.getId();
                List<CartDetail> cartDetails = new ArrayList<>();
                
                String detailSql = "SELECT cd.id as cdId, cd.quantity as cdQuantity, cd.tblCartId, cd.tblProductId, " +
                                  "p.id as pId, p.code, p.name, p.description, p.importPrice, p.unit, p.salePrice, p.quantity as pQuantity, p.category " +
                                  "FROM tblCartDetail cd " +
                                  "JOIN tblProduct p ON cd.tblProductId = p.id " +
                                  "WHERE cd.tblCartId = ?";
                PreparedStatement detailPs = con.prepareStatement(detailSql);
                detailPs.setString(1, cartId);
                ResultSet detailRs = detailPs.executeQuery();
                
                while (detailRs.next()) {
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setId(detailRs.getString("cdId"));
                    cartDetail.setQuantity(detailRs.getInt("cdQuantity"));
                    cartDetail.setTblCartId(detailRs.getString("tblCartId"));
                    cartDetail.setTblProductId(detailRs.getString("tblProductId"));
                    
                    Product product = new Product();
                    product.setId(detailRs.getString("pId"));
                    product.setCode(detailRs.getString("code"));
                    product.setName(detailRs.getString("name"));
                    product.setDescription(detailRs.getString("description"));
                    product.setImportPrice(detailRs.getDouble("importPrice"));
                    product.setUnit(detailRs.getString("unit"));
                    product.setSalePrice(detailRs.getDouble("salePrice"));
                    product.setQuantity(detailRs.getInt("pQuantity"));
                    product.setCategory(detailRs.getString("category"));
                    
                    cartDetail.setProduct(product);
                    cartDetails.add(cartDetail);
                }
                
                cart.setListCartDetail(cartDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cart;
    }

    public void removeProductFromCart(String productId) {
        try {
            String cartId = null;
            
            String getCartSql = "SELECT id FROM tblCart WHERE tblCustomerId IS NULL";
            PreparedStatement getCartPs = con.prepareStatement(getCartSql);
            ResultSet cartRs = getCartPs.executeQuery();
            
            if (cartRs.next()) {
                cartId = cartRs.getString("id");
            }
            
            String deleteSql = "DELETE FROM tblCartDetail WHERE tblCartId = ? AND tblProductId = ?";
            PreparedStatement deletePs = con.prepareStatement(deleteSql);
            deletePs.setString(1, cartId);
            deletePs.setString(2, productId);
            deletePs.executeUpdate();
            
            String totalSql = "SELECT SUM(cd.quantity * p.salePrice) as total " +
                             "FROM tblCartDetail cd " +
                             "JOIN tblProduct p ON cd.tblProductId = p.id " +
                             "WHERE cd.tblCartId = ?";
            PreparedStatement totalPs = con.prepareStatement(totalSql);
            totalPs.setString(1, cartId);
            ResultSet totalRs = totalPs.executeQuery();
            
            double total = 0;
            if (totalRs.next()) {
                total = totalRs.getDouble("total");
            }
            
            String updateCartSql = "UPDATE tblCart SET totalPrice = ? WHERE id = ?";
            PreparedStatement updateCartPs = con.prepareStatement(updateCartSql);
            updateCartPs.setDouble(1, total);
            updateCartPs.setString(2, cartId);
            updateCartPs.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearCart() {
        try {
            String cartId = null;
            
            String getCartSql = "SELECT id FROM tblCart WHERE tblCustomerId IS NULL";
            PreparedStatement getCartPs = con.prepareStatement(getCartSql);
            ResultSet cartRs = getCartPs.executeQuery();
            
            if (cartRs.next()) {
                cartId = cartRs.getString("id");
            }
            
            String deleteSql = "DELETE FROM tblCartDetail WHERE tblCartId = ?";
            PreparedStatement deletePs = con.prepareStatement(deleteSql);
            deletePs.setString(1, cartId);
            deletePs.executeUpdate();
            
            String updateCartSql = "UPDATE tblCart SET totalPrice = 0 WHERE id = ?";
            PreparedStatement updateCartPs = con.prepareStatement(updateCartSql);
            updateCartPs.setString(1, cartId);
            updateCartPs.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
