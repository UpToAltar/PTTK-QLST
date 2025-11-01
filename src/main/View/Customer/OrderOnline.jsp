<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.pttkproject.Model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đặt hàng trực tuyến</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 1400px;
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
        .search-box {
            margin-bottom: 30px;
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .search-box input {
            flex: 1;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }
        .cart-button {
            padding: 12px 30px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        .cart-button:hover {
            background-color: #218838;
        }
        .product-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }
        .product-table th,
        .product-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .product-table th:nth-child(1),
        .product-table td:nth-child(1) {
            width: 10%;
        }
        .product-table th:nth-child(2),
        .product-table td:nth-child(2) {
            width: 20%;
        }
        .product-table th:nth-child(3),
        .product-table td:nth-child(3) {
            width: 25%;
            font-size: 14px;
        }
        .product-table th:nth-child(4),
        .product-table td:nth-child(4) {
            width: 8%;
        }
        .product-table th:nth-child(5),
        .product-table td:nth-child(5) {
            width: 15%;
        }
        .product-table th:nth-child(6),
        .product-table td:nth-child(6) {
            width: 10%;
        }
        .product-table th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }
        .product-table tr:hover {
            background-color: #f9f9f9;
            cursor: pointer;
        }
        .product-name {
            font-weight: bold;
            color: #333;
        }
        .product-code {
            color: #666;
            font-size: 14px;
        }
        .product-price {
            color: #28a745;
            font-weight: bold;
        }
        .no-products {
            text-align: center;
            color: #666;
            font-size: 18px;
            padding: 40px;
        }
        .message {
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
        }
        .message.success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .message.error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Đặt hàng trực tuyến</h1>
        
        <%
            String message = (String) session.getAttribute("message");
            String error = (String) session.getAttribute("error");
            
            if (message != null) {
        %>
        <div class="message success"><%= message %></div>
        <%
                session.removeAttribute("message");
            }
            
            if (error != null) {
        %>
        <div class="message error"><%= error %></div>
        <%
                session.removeAttribute("error");
            }
        %>
        
        <div class="search-box">
            <form action="<%= request.getContextPath() %>/product-servlet" method="get" style="display: flex; gap: 10px; width: 100%;">
                <input type="hidden" name="page" value="orderOnline">
                <input type="hidden" name="action" value="search">
                <input type="text" name="searchName" placeholder="Nhập tên sản phẩm và nhấn Enter để tìm kiếm..." value="${searchName}">
            </form>
            <button name="btnCart" class="cart-button" onclick="location.href='cart-servlet'">Giỏ hàng</button>
        </div>

        <%
            Product[] products = (Product[]) request.getAttribute("listProducts");
            if (products != null && products.length > 0) {
        %>
        
        <table name="tblProduct" class="product-table">
            <thead>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Mô tả</th>
                    <th>Đơn vị</th>
                    <th>Giá bán</th>
                    <th>Số lượng</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Product product : products) {
                %>
                <tr onclick="location.href='product-servlet?action=selectProduct&productId=<%= product.getId() %>'">
                    <td><%= product.getCode() %></td>
                    <td class="product-name"><%= product.getName() %></td>
                    <td><%= product.getDescription() != null ? product.getDescription() : "" %></td>
                    <td><%= product.getUnit() %></td>
                    <td class="product-price"><%= String.format("%,.0f", product.getSalePrice()) %> VNĐ</td>
                    <td><%= product.getQuantity() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        
        <%
            } else {
        %>
        <div class="no-products">Không tìm thấy sản phẩm nào</div>
        <%
            }
        %>
    </div>
</body>
</html>

