package org.example.pttkproject.DAO;

import org.example.pttkproject.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DAO {
    
    public ProductDAO() {
        super();
    }

    public Product[] getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM tblProduct";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getString("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImportPrice(rs.getDouble("importPrice"));
                product.setUnit(rs.getString("unit"));
                product.setSalePrice(rs.getDouble("salePrice"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(rs.getString("category"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products.toArray(new Product[0]);
    }

    public Product[] getProductsByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM tblProduct WHERE name LIKE ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getString("id"));
                    product.setCode(rs.getString("code"));
                    product.setName(rs.getString("name"));
                    product.setDescription(rs.getString("description"));
                    product.setImportPrice(rs.getDouble("importPrice"));
                    product.setUnit(rs.getString("unit"));
                    product.setSalePrice(rs.getDouble("salePrice"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setCategory(rs.getString("category"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return products.toArray(new Product[0]);
    }

    public Product getProductById(String id) {
        Product product = null;
        String sql = "SELECT * FROM tblProduct WHERE id = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = new Product();
                    product.setId(rs.getString("id"));
                    product.setCode(rs.getString("code"));
                    product.setName(rs.getString("name"));
                    product.setDescription(rs.getString("description"));
                    product.setImportPrice(rs.getDouble("importPrice"));
                    product.setUnit(rs.getString("unit"));
                    product.setSalePrice(rs.getDouble("salePrice"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setCategory(rs.getString("category"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return product;
    }

    public String updateProducts(Product[] listProducts) {
        // Kiểm tra trùng mã sản phẩm trong danh sách
        for (int i = 0; i < listProducts.length; i++) {
            for (int j = i + 1; j < listProducts.length; j++) {
                if (listProducts[i].getCode().equals(listProducts[j].getCode())) {
                    return "Lỗi: Mã sản phẩm '" + listProducts[i].getCode() + "' bị trùng lặp trong danh sách!";
                }
            }
        }
        
        // Kiểm tra trùng mã sản phẩm với các sản phẩm khác trong database
        String checkSql = "SELECT id FROM tblProduct WHERE code = ? AND id != ?";
        for (Product product : listProducts) {
            try (PreparedStatement ps = con.prepareStatement(checkSql)) {
                ps.setString(1, product.getCode());
                ps.setString(2, product.getId());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return "Lỗi: Mã sản phẩm '" + product.getCode() + "' đã tồn tại trong hệ thống!";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Lỗi: Không thể kiểm tra mã sản phẩm. " + e.getMessage();
            }
        }
        
        // Cập nhật sản phẩm
        String updateSql = "UPDATE tblProduct SET code=?, name=?, description=?, importPrice=?, unit=?, salePrice=?, quantity=?, category=? WHERE id=?";
        
        try (PreparedStatement ps = con.prepareStatement(updateSql)) {
            for (Product product : listProducts) {
                ps.setString(1, product.getCode());
                ps.setString(2, product.getName());
                ps.setString(3, product.getDescription());
                ps.setDouble(4, product.getImportPrice());
                ps.setString(5, product.getUnit());
                ps.setDouble(6, product.getSalePrice());
                ps.setInt(7, product.getQuantity());
                ps.setString(8, product.getCategory());
                ps.setString(9, product.getId());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            
            // Kiểm tra kết quả cập nhật
            int successCount = 0;
            for (int result : results) {
                if (result > 0) {
                    successCount++;
                }
            }
            
            if (successCount == listProducts.length) {
                return "Cập nhật thành công " + successCount + " sản phẩm!";
            } else {
                return "Cập nhật thành công " + successCount + "/" + listProducts.length + " sản phẩm!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi: Không thể cập nhật sản phẩm. " + e.getMessage();
        }
    }
}
