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
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Cart;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.OrderDetail;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductImage;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductPrice;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.OrderDetailServices;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.OrderServices;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.ProductPriceServices;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.ProductServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Inject
    private ProductPriceServices  productPriceServices;
    public void init() {
        productPriceServices = new ProductPriceServices(); // Initialize your OrderService
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            int id = Integer.parseInt(req.getParameter("id"));
            HttpSession session = req.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (cart_list == null) {
                ArrayList<Cart> carts = new ArrayList<>();
                Cart cart = new Cart();
                cart.setId(id);
                cart.setQuantity(1);
                carts.add(cart);
                session.setAttribute("cart-list", carts);
            } else {
                boolean found = false;
                for (Cart c : cart_list) {
                    if (c.getId() == id) {
                        c.setQuantity(c.getQuantity() + 1);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Cart cart = new Cart();
                    cart.setId(id);
                    cart.setQuantity(1);
                    cart_list.add(cart);
                }
                session.setAttribute("cart-list", cart_list);
            }
            resp.sendRedirect("pageProduct.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}

