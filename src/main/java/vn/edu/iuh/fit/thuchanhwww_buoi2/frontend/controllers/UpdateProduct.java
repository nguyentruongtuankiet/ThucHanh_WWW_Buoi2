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
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.OrderDetailServices;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.OrderServices;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.ProductPriceServices;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.ProductServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
    @Inject
    private ProductServices productPriceServices;

    public void init() {
        productPriceServices = new ProductServices(); // Initialize your OrderService
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter();) {
            String action = req.getParameter("action");
            long id = Long.parseLong(req.getParameter("id"));
            HttpSession session = req.getSession();
            List<Product> productList = productPriceServices.getAll();

            if (action != null) {
                if (action.equals("delete")) {
                    for (Product product : productList) {
                        if (product.getId() == id) {
                            product.setStatus(ProductStatus.IN_ACTIVE);
                            productPriceServices.updateProduct(product);
                            resp.sendRedirect("CRUDProduct.jsp");
                        }
                    }

                }

            } else {
                resp.sendRedirect("CRUDProduct.jsp");
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("add")) {
            // Lấy thông tin từ form HTML
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String unit = req.getParameter("unit");
            String manufacturerName = req.getParameter("manufacturerName");
            int status = Integer.parseInt(req.getParameter("status"));

            // Tạo đối tượng Product từ thông tin lấy từ form
            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setDescription(description);
            newProduct.setUnit(unit);
            newProduct.setManufacturerName(manufacturerName);
            newProduct.setStatus(status == 1 ? ProductStatus.ACTIVE : ProductStatus.IN_ACTIVE);

            // Thêm sản phẩm mới vào cơ sở dữ liệu
            productPriceServices.addProduct(newProduct);
            resp.sendRedirect("CRUDProduct.jsp");
        } else {
            resp.sendRedirect("CRUDProduct.jsp");
        }
    }
}




