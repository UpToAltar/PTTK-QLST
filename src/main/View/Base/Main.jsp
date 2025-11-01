<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userRole = (String) session.getAttribute("userRole");
    Object loggedInUser = null;
    String userName = "";
    
    if ("Khách hàng".equals(userRole)) {
        loggedInUser = session.getAttribute("customer");
        if (loggedInUser != null) {
            userName = ((org.example.pttkproject.Model.Customer) loggedInUser).getFullName();
        }
    } else if ("Nhân viên kho".equals(userRole)) {
        loggedInUser = session.getAttribute("warehouseStaff");
        if (loggedInUser != null) {
            userName = ((org.example.pttkproject.Model.WarehouseStaff) loggedInUser).getFullName();
        }
    }
    
    if (loggedInUser == null) {
        response.sendRedirect(request.getContextPath() + "/Base/Login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Hệ thống quản lý sản phẩm</title>
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
            margin-bottom: 10px;
        }
        .user-info {
            text-align: center;
            color: #666;
            margin-bottom: 30px;
            padding: 10px;
            background-color: #f8f9fa;
            border-radius: 5px;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .btn-logout {
            background-color: #dc3545;
        }
        .btn-logout:hover {
            background-color: #c82333;
        }
        .btn-warning {
            background-color: #ffc107;
            color: #000;
        }
        .btn-warning:hover {
            background-color: #e0a800;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Hệ thống quản lý siêu thị</h1>
        
        <div class="user-info">
            Xin chào, <strong><%= userName %></strong> (<%= userRole %>)
        </div>
        
        <% if ("Khách hàng".equals(userRole)) { %>
            <form action="<%= request.getContextPath() %>/product-servlet" method="get">
                <input type="hidden" name="page" value="orderOnline">
                <input type="submit" name="btnOrderOnline" value="Đặt hàng trực tuyến" class="btn">
            </form>
        <% } %>
        
        <% if ("Nhân viên kho".equals(userRole)) { %>
            <form action="<%= request.getContextPath() %>/WarehouseStaff/ManageProduct.jsp" method="get">
                <input type="submit" name="btnManageProduct" value="Chỉnh sửa mặt hàng" class="btn btn-warning">
            </form>
        <% } %>
        
        <form action="<%= request.getContextPath() %>/login-servlet" method="get">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Đăng xuất" class="btn btn-logout">
        </form>
    </div>
</body>
</html>
