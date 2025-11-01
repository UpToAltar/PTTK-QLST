<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.pttkproject.Model.Customer" %>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    if (customer == null) {
        response.sendRedirect(request.getContextPath() + "/Base/Login.jsp");
        return;
    }
    
    String defaultName = customer.getFullName() != null ? customer.getFullName() : "";
    String defaultAddress = customer.getAddress() != null ? customer.getAddress() : "";
    String defaultPhone = customer.getPhone() != null ? customer.getPhone() : "";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin khách hàng</title>
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
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"],
        input[type="tel"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input:focus {
            outline: none;
            border-color: #007bff;
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
        .required {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Thông tin giao hàng</h1>
        
        <form action="<%= request.getContextPath() %>/customer-servlet" method="post">
            <div class="form-group">
                <label for="receiverName">Tên người nhận: <span class="required">*</span></label>
                <input type="text" id="receiverName" name="receiverName" value="<%= defaultName %>" required>
            </div>
            
            <div class="form-group">
                <label for="shipAddress">Địa chỉ giao hàng: <span class="required">*</span></label>
                <input type="text" id="shipAddress" name="shipAddress" value="<%= defaultAddress %>" required>
            </div>
            
            <div class="form-group">
                <label for="phone">Số điện thoại: <span class="required">*</span></label>
                <input type="tel" id="phone" name="phone" value="<%= defaultPhone %>" required>
            </div>
            
            <div class="button-group">
                <button name="btnBack" type="button" class="btn btn-secondary" onclick="location.href='cart-servlet'">Quay lại</button>
                <button name="btnConfirm" type="submit" class="btn btn-primary">Xác nhận</button>
            </div>
        </form>
    </div>
</body>
</html>

