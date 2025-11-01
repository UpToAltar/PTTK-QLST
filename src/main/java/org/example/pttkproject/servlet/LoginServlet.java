package org.example.pttkproject.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.pttkproject.DAO.UserDAO;
import org.example.pttkproject.Model.Customer;
import org.example.pttkproject.Model.WarehouseStaff;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if ("logout".equals(action)) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            res.sendRedirect(req.getContextPath() + "/Base/Login.jsp");
            return;
        }
        
        req.getRequestDispatcher("/Base/Login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Object user = userDAO.login(username, password);
        
        if (user != null) {
            HttpSession session = req.getSession();
            
            if (user instanceof Customer) {
                session.setAttribute("customer", user);
                session.setAttribute("userRole", "Khách hàng");
            } else if (user instanceof WarehouseStaff) {
                session.setAttribute("warehouseStaff", user);
                session.setAttribute("userRole", "Nhân viên kho");
            }
            
            res.sendRedirect(req.getContextPath() + "/Base/Main.jsp");
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("/Base/Login.jsp").forward(req, res);
        }
    }
}

