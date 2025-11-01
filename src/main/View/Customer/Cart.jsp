<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.pttkproject.Model.Product" %>
<%@ page import="org.example.pttkproject.Model.Cart" %>
<%@ page import="org.example.pttkproject.Model.CartDetail" %>
<!DOCTYPE html>
<html>
<head>
    <title>Giỏ hàng</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 1000px;
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
        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }
        .cart-table th,
        .cart-table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .cart-table th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }
        .cart-table tr:hover {
            background-color: #f9f9f9;
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
            background-color: #f9f9f9;
            border-radius: 8px;
            margin-bottom: 20px;
        }
        .total-price {
            font-size: 24px;
            color: #28a745;
            font-weight: bold;
        }
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: flex-end;
        }
        .btn {
            padding: 15px 30px;
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
        .btn-danger {
            background-color: #dc3545;
            color: white;
            padding: 8px 15px;
            font-size: 14px;
        }
        .btn-danger:hover {
            background-color: #c82333;
        }
        .empty-cart {
            text-align: center;
            padding: 50px;
            color: #666;
        }
        .empty-cart-icon {
            font-size: 64px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Giỏ hàng của bạn</h1>
        
        <%
            Cart cart = (Cart) request.getAttribute("cart");
            if (cart == null) {
                cart = (Cart) session.getAttribute("cart");
            }
            
            if (cart != null && cart.getListCartDetail() != null && !cart.getListCartDetail().isEmpty()) {
        %>
        
        <table class="cart-table" name="tblProductSelected">
            <thead>
                <tr>
                    <th>Sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th>Thao tác</th>
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
                    <td>
                        <form action="<%= request.getContextPath() %>/cart-servlet" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="productId" value="<%= product.getId() %>">
                            <button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?')">Xóa</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        
        <div name="txtTotalPrice" class="total-section">
            <h2>Tổng tiền: <span class="total-price"><%= String.format("%,.0f", cart != null ? cart.getTotalPrice() : 0) %> VNĐ</span></h2>
        </div>
        
        <div class="button-group">
            <a name="btnBack" href="<%= request.getContextPath() %>/product-servlet?page=orderOnline" class="btn btn-secondary">Tiếp tục mua hàng</a>
            <a name="btnOrder" href="<%= request.getContextPath() %>/Customer/CustomerInfo.jsp" class="btn btn-primary">Đặt hàng</a>
        </div>
        
        <%
            } else {
        %>
        
        <div class="empty-cart">
            <div class="empty-cart-icon">🛒</div>
            <h2>Giỏ hàng của bạn đang trống</h2>
            <p>Hãy thêm sản phẩm vào giỏ hàng để tiếp tục mua sắm</p>
            <a name="btnBack" href="<%= request.getContextPath() %>/product-servlet?page=orderOnline" class="btn btn-primary">Mua sắm ngay</a>
        </div>
        
        <%
            }
        %>
    </div>
</body>
</html>

