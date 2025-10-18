<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa thông tin mặt hàng</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 95%;
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
        .search-section {
            margin-bottom: 30px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
            display: flex;
            align-items: center;
            gap: 20px;
        }
        .search-input {
            flex: 1;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }
        .search-btn {
            padding: 12px 25px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .search-btn:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
            min-width: 120px;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        input[type="text"], input[type="number"] {
            width: calc(100% - 16px);
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 3px;
            font-size: 14px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #1e7e34;
        }
        .back-btn {
            background-color: #6c757d;
            margin-bottom: 20px;
        }
        .back-btn:hover {
            background-color: #545b62;
        }
        .message {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            text-align: center;
        }
        .success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="ManageProduct.jsp" class="btn back-btn">← Quay lại</a>
        
        <h1>Sửa thông tin mặt hàng</h1>
        
        <c:if test="${not empty message}">
            <div class="message ${messageType == 'error' ? 'error' : 'success'}">
                ${message}
            </div>
        </c:if>
        
        <div class="search-section">
            <form action="product-servlet" method="get" style="flex: 1;">
                <input type="hidden" name="action" value="search">
                <input type="text" name="searchName" placeholder="Nhập tên sản phẩm cần tìm kiếm..." class="search-input" 
                       value="${searchName}" onkeypress="if(event.key==='Enter') this.form.submit()">
            </form>
        </div>
        
        <form action="product-servlet" method="post" id="updateForm">
            <table>
                <thead>
                    <tr>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Mô tả</th>
                        <th>Giá nhập</th>
                        <th>Đơn vị</th>
                        <th>Giá bán</th>
                        <th>Số lượng</th>
                        <th>Danh mục</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${listProducts}" varStatus="status">
                        <tr>
                            <td>
                                <input type="hidden" name="productId" value="${product.id}">
                                <input type="text" name="productCode" value="${product.code}" required>
                            </td>
                            <td><input type="text" name="productName" value="${product.name}" required></td>
                            <td><input type="text" name="productDescription" value="${product.description}"></td>
                            <td>
                                <input type="text" 
                                    name="productImportPrice" 
                                    value="<fmt:formatNumber value='${product.importPrice}' type='number' minFractionDigits='2' />" 
                                    required>
                            </td>

                            <td><input type="text" name="productUnit" value="${product.unit}" required></td>
                            <td>
                                <input type="text" 
                                    name="productSalePrice" 
                                    value="<fmt:formatNumber value='${product.salePrice}' type='number' minFractionDigits='2' />" 
                                    required>
                            </td>

                            <td><input type="number" name="productQuantity" value="${product.quantity}" required></td>
                            <td><input type="text" name="productCategory" value="${product.category}" required></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            
            <div style="text-align: right; margin-top: 20px;">
                <input type="submit" name="btnUpdate" value="Sửa" class="btn">
            </div>
        </form>
    </div>
</body>
</html>
