package org.example.pttkproject.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pttkproject.DAO.ProductDAO;
import org.example.pttkproject.Model.Product;

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
        String page = req.getParameter("page");
        
        if ("selectProduct".equals(action)) {
            String productId = req.getParameter("productId");
            Product product = productDAO.getProductById(productId);
            
            req.getSession().setAttribute("selectedProduct", product);
            
            req.setAttribute("product", product);
            req.getRequestDispatcher("/Customer/TypeQuantity.jsp").forward(req, res);
        } else if ("orderOnline".equals(page)) {
            if ("search".equals(action)) {
                String searchName = req.getParameter("searchName");
                Product[] products = productDAO.getProductsByName(searchName);
                req.setAttribute("listProducts", products);
                req.setAttribute("searchName", searchName);
            } else {
                Product[] products = productDAO.getAllProducts();
                req.setAttribute("listProducts", products);
            }
            req.getRequestDispatcher("/Customer/OrderOnline.jsp").forward(req, res);
        } else {
            if ("search".equals(action)) {
                String searchName = req.getParameter("searchName");
                Product[] products = productDAO.getProductsByName(searchName);
                req.setAttribute("listProducts", products);
                req.setAttribute("searchName", searchName);
            } else {
                Product[] products = productDAO.getAllProducts();
                req.setAttribute("listProducts", products);
            }
            req.getRequestDispatcher("/WarehouseStaff/UpdateProduct.jsp").forward(req, res);
        }
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
                product.setImportPrice(Double.parseDouble(importPrices[i].replace(".", "").replace(",", ".")));
                product.setUnit(units[i]);
                product.setSalePrice(Double.parseDouble(salePrices[i].replace(".", "").replace(",", ".")));
                product.setQuantity(Integer.parseInt(quantities[i]));
                product.setCategory(categories[i]);
                productList.add(product);

                System.out.println(product.getSalePrice());
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
        
        req.getRequestDispatcher("/WarehouseStaff/UpdateProduct.jsp").forward(req, res);
    }
}
