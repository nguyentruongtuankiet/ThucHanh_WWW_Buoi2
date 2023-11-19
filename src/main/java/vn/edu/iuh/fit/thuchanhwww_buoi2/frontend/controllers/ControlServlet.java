package vn.edu.iuh.fit.thuchanhwww_buoi2.frontend.controllers;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.converters.ProductStatusConverter;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.*;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/login")
public class ControlServlet extends HttpServlet {
    @Inject
    private EmployeeServices employeeServices;

    public void init() {
        employeeServices = new EmployeeServices(); // Initialize your OrderService
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("users")) {
            String name = req.getParameter("username");
            String password = req.getParameter("password");
            List<Employee> employeeList = employeeServices.getAll();

            boolean userFound = false;
            for (Employee e : employeeList) {
                if (e.getFullName().equals(name) && e.getEmail().equals(password)) {
                    userFound = true;
                    break;
                }
            }

            if (userFound) {
                resp.sendRedirect("option.jsp");
            } else {
                req.setAttribute("error", "Tài khoản không tồn tại!!!!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
    }
}




