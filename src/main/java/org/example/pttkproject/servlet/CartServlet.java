package org.example.pttkproject.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.pttkproject.DAO.CartDAO;
import org.example.pttkproject.Model.Cart;
import org.example.pttkproject.Model.Product;

import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/cart-servlet")
public class CartServlet extends HttpServlet {

    private CartDAO cartDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        cartDAO = new CartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = cartDAO.getCart();
        
        session.setAttribute("cart", cart);
        req.setAttribute("cart", cart);
        
        req.getRequestDispatcher("/Customer/Cart.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        
        if ("add".equals(action)) {
            Product product = (Product) session.getAttribute("selectedProduct");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            
            if (product != null) {
                if (quantity <= 0) {
                    session.setAttribute("error", "Số lượng phải lớn hơn 0!");
                } else if (quantity > product.getQuantity()) {
                    session.setAttribute("error", "Số lượng không đủ! Chỉ còn " + product.getQuantity() + " sản phẩm.");
                } else {
                    cartDAO.addProductToCart(product, quantity);
                    session.setAttribute("message", "Đã thêm sản phẩm vào giỏ hàng!");
                }
            }
            
            res.sendRedirect(req.getContextPath() + "/product-servlet?page=orderOnline");
            
        } else if ("remove".equals(action)) {
            String productId = req.getParameter("productId");
            cartDAO.removeProductFromCart(productId);
            Cart cart = cartDAO.getCart();
            session.setAttribute("cart", cart);
            res.sendRedirect(req.getContextPath() + "/cart-servlet");
        }
    }
}

