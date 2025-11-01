package org.example.pttkproject.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.pttkproject.Model.Customer;

import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            res.sendRedirect(req.getContextPath() + "/Base/Login.jsp");
            return;
        }
        
        String receiverName = req.getParameter("receiverName");
        String shipAddress = req.getParameter("shipAddress");
        String phone = req.getParameter("phone");

        Customer newCustomer = new Customer();
        newCustomer.setId(customer.getId());
        newCustomer.setUserId(customer.getUserId());
        newCustomer.setFullName(receiverName);
        newCustomer.setAddress(shipAddress);
        newCustomer.setPhone(phone);
        newCustomer.setRole(customer.getRole());
        newCustomer.setNote(customer.getNote());
        newCustomer.setFullName(receiverName);
        newCustomer.setAddress(shipAddress);
        newCustomer.setPhone(phone);
        
        session.setAttribute("newCustomer", newCustomer);
        
        req.getRequestDispatcher("/Customer/Confirm.jsp").forward(req, res);
    }
}

