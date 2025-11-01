package org.example.pttkproject.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.pttkproject.DAO.OrderOnlineDAO;
import org.example.pttkproject.Model.Cart;
import org.example.pttkproject.Model.Customer;

import java.io.IOException;

@WebServlet(name = "OrderOnlineServlet", value = "/order-online-servlet")
public class OrderOnlineServlet extends HttpServlet {

    private OrderOnlineDAO orderOnlineDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        orderOnlineDAO = new OrderOnlineDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        Customer customer = (Customer) session.getAttribute("newCustomer");
        if (customer == null) {
            res.sendRedirect(req.getContextPath() + "/Base/Login.jsp");
            return;
        }

        if (customer.getFullName() == null || customer.getAddress() == null || customer.getPhone() == null) {
            res.sendRedirect(req.getContextPath() + "/Customer/CustomerInfo.jsp");
            return;
        }

        Cart cart = (Cart) session.getAttribute("cart");
        
        boolean success = orderOnlineDAO.createOrder(customer, cart);
        
        if (success) {
            session.removeAttribute("cart");
            req.setAttribute("message", "Đặt hàng thành công!");
            req.setAttribute("messageType", "success");
        } else {
            req.setAttribute("message", "Đặt hàng thất bại!");
            req.setAttribute("messageType", "error");
        }
        
        req.getRequestDispatcher("/Customer/Confirm.jsp").forward(req, res);
    }
}

