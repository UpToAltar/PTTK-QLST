package org.example.pttkproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pttkproject.dao.ProductDAO;
import org.example.pttkproject.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if ("search".equals(action)) {
            // Tìm kiếm sản phẩm theo tên
            String searchName = req.getParameter("searchName");
            Product[] products = productDAO.getProductsByName(searchName);
            req.setAttribute("listProducts", products);
            req.setAttribute("searchName", searchName);
        } else {
            // Lấy tất cả sản phẩm
            Product[] products = productDAO.getAllProducts();
            req.setAttribute("listProducts", products);
        }
        
        req.getRequestDispatcher("/UpdateProduct.jsp").forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Lấy danh sách sản phẩm từ form
        List<Product> productList = new ArrayList<>();
        
        String[] ids = req.getParameterValues("productId");
        String[] codes = req.getParameterValues("productCode");
        String[] names = req.getParameterValues("productName");
        String[] descriptions = req.getParameterValues("productDescription");
        String[] importPrices = req.getParameterValues("productImportPrice");
        String[] units = req.getParameterValues("productUnit");
        String[] salePrices = req.getParameterValues("productSalePrice");
        String[] quantities = req.getParameterValues("productQuantity");
        String[] categories = req.getParameterValues("productCategory");
        
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Product product = new Product();
                product.setId(ids[i]);
                product.setCode(codes[i]);
                product.setName(names[i]);
                product.setDescription(descriptions[i]);
                System.out.println(importPrices[i]);
                product.setImportPrice(Float.parseFloat(importPrices[i].replace(".", "").replace(",", ".")));
                product.setUnit(units[i]);
                product.setSalePrice(Float.parseFloat(salePrices[i].replace(".", "").replace(",", ".")));
                product.setQuantity(Integer.parseInt(quantities[i]));
                product.setCategory(categories[i]);
                productList.add(product);
            }
        }
        
        // Cập nhật sản phẩm
        Product[] products = productList.toArray(new Product[0]);
        String message = productDAO.updateProducts(products);
        
        // Lấy lại danh sách sản phẩm sau khi cập nhật
        Product[] updatedProducts = productDAO.getAllProducts();
        req.setAttribute("listProducts", updatedProducts);
        req.setAttribute("message", message);
        
        // Kiểm tra nếu có lỗi thì đánh dấu
        if (message.startsWith("Lỗi:")) {
            req.setAttribute("messageType", "error");
        } else {
            req.setAttribute("messageType", "success");
        }
        
        req.getRequestDispatcher("/UpdateProduct.jsp").forward(req, res);
    }
}
