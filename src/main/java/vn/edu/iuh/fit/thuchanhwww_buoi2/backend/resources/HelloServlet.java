package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.resources;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ProductReponsitory;

@WebServlet(name = "MyHelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if("MappingTable".equals(action)) {
        ProductReponsitory productReponsitory = new ProductReponsitory();

        } else if ("allproduct".equals(action)) {
            ProductReponsitory productReponsitory = new ProductReponsitory();
            List<Product> products = productReponsitory.getAllProductsWithImages();
            request.setAttribute("products", products);
            request.getRequestDispatcher("/all-products.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}