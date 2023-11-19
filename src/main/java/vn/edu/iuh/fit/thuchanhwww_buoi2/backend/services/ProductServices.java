package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Cart;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ProductReponsitory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServices {
    @Inject
    private ProductReponsitory productReponsitory;


    @Inject
    public ProductServices(){
        productReponsitory = new ProductReponsitory() ;
    }
    public boolean addProduct(Product product){
        return productReponsitory.addProduct(product);
    }
    public boolean updateProduct(Product product){
        return  productReponsitory.updateProduct(product);
    }
    public boolean deleteProduct(long id){
        return productReponsitory.deleteProduct(id);
    }
    public Product getProductById(Long id){
        return productReponsitory.getProductById(id);
    }
    public List<Product> getAll(){
        return productReponsitory.getAll();
    }

    public void setStatus(Product product, ProductStatus productStatus){
        productReponsitory.setStatus(product, productStatus);
    }
    public List<Product> getActiveProduct(){
        return productReponsitory.getActiveProduct();
    }
    public void updateStatus(long id, ProductStatus productStatus){
        productReponsitory.updateStatus(id, productStatus);
    }

    public List<Product> getAllProductsWithImagesAndPrices(){
        return productReponsitory.getAllProductsWithImagesAndPrices();
    }
    public List<Product> getAllProductsWithImages() {
        return productReponsitory.getAllProductsWithImages();
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartlist){
        return productReponsitory.getCartProducts(cartlist);
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList){
        return  productReponsitory.getTotalCartPrice(cartList);
    }

}