<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.pttkproject.Model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chọn số lượng</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .product-info {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 30px;
            background-color: #f9f9f9;
        }
        .product-name {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }
        .product-code {
            color: #666;
            margin-bottom: 5px;
        }
        .product-price {
            font-size: 22px;
            color: #28a745;
            font-weight: bold;
            margin: 15px 0;
        }
        .product-stock {
            color: #666;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="number"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        .button-group {
            display: flex;
            gap: 10px;
            margin-top: 30px;
        }
        .btn {
            flex: 1;
            padding: 15px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            font-weight: bold;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        .btn-secondary:hover {
            background-color: #545b62;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Chọn số lượng sản phẩm</h1>
        
        <%
            Product product = (Product) request.getAttribute("product");
            if (product != null) {
        %>
        
        <div class="product-info">
            <div class="product-name"><%= product.getName() %></div>
            <div class="product-code">Mã sản phẩm: <%= product.getCode() %></div>
            <div class="product-price"><%= String.format("%,.0f", product.getSalePrice()) %> VNĐ</div>
            <div class="product-stock">Số lượng còn lại: <%= product.getQuantity() %></div>
        </div>
        
        <form action="<%= request.getContextPath() %>/cart-servlet" method="post">
            <input type="hidden" name="action" value="add">
            
            <div class="form-group">
                <label for="quantity">Nhập số lượng:</label>
                <input type="number" id="quantity" name="quantity" min="1" max="<%= product.getQuantity() %>" value="1" required>
            </div>
            
            <div class="button-group">
                <button type="button" class="btn btn-secondary" onclick="location.href='product-servlet?page=orderOnline'">Quay lại</button>
                <button name="btnAddToCart" type="submit" class="btn btn-primary">Thêm vào giỏ hàng</button>
            </div>
        </form>
        
        <%
            } else {
        %>
        <p style="text-align: center; color: #666;">Không tìm thấy thông tin sản phẩm</p>
        <button name="btnBack" class="btn btn-secondary" onclick="location.href='product-servlet?page=orderOnline'">Quay lại</button>
        <%
            }
        %>
    </div>
</body>
</html>

