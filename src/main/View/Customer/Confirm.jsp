<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.pttkproject.Model.Product" %>
<%@ page import="org.example.pttkproject.Model.Cart" %>
<%@ page import="org.example.pttkproject.Model.CartDetail" %>
<%@ page import="org.example.pttkproject.Model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xác nhận đơn hàng</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
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
        .section {
            margin-bottom: 30px;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
        }
        .section h2 {
            color: #007bff;
            margin-bottom: 15px;
            font-size: 20px;
        }
        .info-row {
            display: flex;
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
        .info-row:last-child {
            border-bottom: none;
        }
        .info-label {
            font-weight: bold;
            width: 150px;
            color: #666;
        }
        .info-value {
            flex: 1;
            color: #333;
        }
        .product-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        .product-table th,
        .product-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .product-table th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }
        .product-name {
            font-weight: bold;
            color: #333;
        }
        .product-code {
            color: #666;
            font-size: 14px;
        }
        .price {
            color: #28a745;
            font-weight: bold;
        }
        .total-section {
            text-align: right;
            padding: 20px;
            background-color: #28a745;
            color: white;
            border-radius: 8px;
            margin: 20px 0;
        }
        .total-price {
            font-size: 28px;
            font-weight: bold;
        }
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-top: 30px;
        }
        .btn {
            padding: 15px 40px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            font-weight: bold;
            text-decoration: none;
            display: inline-block;
        }
        .btn-primary {
            background-color: #28a745;
            color: white;
        }
        .btn-primary:hover {
            background-color: #218838;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        .btn-secondary:hover {
            background-color: #545b62;
        }
        .success-message {
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            color: #155724;
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 30px;
            text-align: center;
        }
        .success-icon {
            font-size: 48px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Xác nhận đơn hàng</h1>
        
        <%
            String message = (String) request.getAttribute("message");
            String messageType = (String) request.getAttribute("messageType");
            
            if (message != null && "success".equals(messageType)) {
        %>
        
        <div class="success-message">
            <div class="success-icon">✓</div>
            <h2><%= message %></h2>
            <p>Cảm ơn bạn đã đặt hàng! Chúng tôi sẽ liên hệ với bạn trong thời gian sớm nhất.</p>
        </div>
        
        <div class="button-group">
            <a href="<%= request.getContextPath() %>/product-servlet?page=orderOnline" class="btn btn-primary">Tiếp tục mua hàng</a>
        </div>
        
        <%
            } else {
                Customer customer = (Customer) session.getAttribute("newCustomer");
                Cart cart = (Cart) session.getAttribute("cart");
        %>
        
        <div class="section">
            <h2>Thông tin giao hàng</h2>
            <div class="info-row">
                <div class="info-label">Tên người nhận:</div>
                <div class="info-value"><%= customer.getFullName() != null ? customer.getFullName() : "" %></div>
            </div>
            <div class="info-row">
                <div class="info-label">Số điện thoại:</div>
                <div class="info-value"><%= customer.getPhone() != null ? customer.getPhone() : "" %></div>
            </div>
            <div class="info-row">
                <div class="info-label">Địa chỉ giao hàng:</div>
                <div class="info-value"><%= customer.getAddress() != null ? customer.getAddress() : "" %></div>
            </div>
        </div>
        
        <div class="section">
            <h2>Danh sách sản phẩm</h2>
            
            <%
                if (cart != null && cart.getListCartDetail() != null && !cart.getListCartDetail().isEmpty()) {
            %>
            
            <table class="product-table" name="tblProduct">
                <thead>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (CartDetail cartDetail : cart.getListCartDetail()) {
                            Product product = cartDetail.getProduct();
                            int quantity = cartDetail.getQuantity();
                            double subtotal = product.getSalePrice() * quantity;
                    %>
                    <tr>
                        <td>
                            <div class="product-name"><%= product.getName() %></div>
                            <div class="product-code">Mã: <%= product.getCode() %></div>
                        </td>
                        <td class="price"><%= String.format("%,.0f", product.getSalePrice()) %> VNĐ</td>
                        <td><%= quantity %></td>
                        <td class="price"><%= String.format("%,.0f", subtotal) %> VNĐ</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            
            <div name="txtTotalPrice" class="total-section">
                <h3>Tổng giá trị đơn hàng</h3>
                <div class="total-price"><%= String.format("%,.0f", cart.getTotalPrice()) %> VNĐ</div>
            </div>
            
            <%
                }
            %>
        </div>
        
        <form action="<%= request.getContextPath() %>/order-online-servlet" method="post">
            <div class="button-group">
                <button name="btnBack" type="button" class="btn btn-secondary" onclick="location.href='cart-servlet'">Quay lại</button>
                <button name="btnConfirm" type="submit" class="btn btn-primary">Xác nhận đặt hàng</button>
            </div>
        </form>
        
        <%
            }
        %>
    </div>
</body>
</html>

