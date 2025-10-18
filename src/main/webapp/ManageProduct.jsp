<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý mặt hàng</title>
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
        .btn-update {
            background-color: #28a745;
        }
        .btn-update:hover {
            background-color: #1e7e34;
        }
        .btn-add {
            background-color: #17a2b8;
        }
        .btn-add:hover {
            background-color: #138496;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn-delete:hover {
            background-color: #c82333;
        }
        .btn-view {
            background-color: #6c757d;
        }
        .btn-view:hover {
            background-color: #545b62;
        }
        .back-btn {
            background-color: #6c757d;
            width: auto;
            display: inline-block;
            padding: 10px 20px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="Main.jsp" class="btn back-btn">← Quay lại</a>
        
        <h1>Quản lý mặt hàng</h1>
        
        <form action="product-servlet" method="get">
            <input type="submit" name="btnUpdateProduct" value="Sửa thông tin mặt hàng" class="btn btn-update">
        </form>
        
        <form action="#" method="get">
            <input type="submit" name="btnAddProduct" value="Thêm mặt hàng" class="btn btn-add">
        </form>
        
        <form action="#" method="get">
            <input type="submit" name="btnDeleteProduct" value="Xóa mặt hàng" class="btn btn-delete">
        </form>
        
        <form action="#" method="get">
            <input type="submit" name="btnViewProduct" value="Xem mặt hàng" class="btn btn-view">
        </form>
    </div>
</body>
</html>
