package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Cart;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductPrice;

import java.util.*;

public class ProductReponsitory {
    private EntityManager em ;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductReponsitory(){
        em = ConnectDB.getConnectDB().getEmf().createEntityManager();
    }

    public boolean addProduct(Product product){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(product);
            tr.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean updateProduct(Product product){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(product);
            tr.commit();
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean deleteProduct(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.remove(getProductById(id));
            tr.commit();
            return true;
        }
        catch (Exception e){
            logger.info(e.getMessage());
            tr.commit();
        }
        return false;
    }
    public Product getProductById(Long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Product product = em.find(Product.class,id);
            tr.commit();
            return product;
        }
        catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }
    public List<Product> getAll(){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            List<Product> productList = em.createNativeQuery("SELECT * FROM product", Product.class).getResultList();
            tr.commit();
            return productList;
        }catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
            return Collections.emptyList();
        }
    }
    public List<Product> getAllProductsWithImages() {
        EntityTransaction tr = em.getTransaction();
        try {
            TypedQuery<Product> query = em.createQuery(
                    "SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.productImageList", Product.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    public List<Product> getAllProductsWithImagesAndPrices() {
        TypedQuery<Product> query = em.createQuery("SELECT DISTINCT p FROM Product p " +
                "LEFT JOIN FETCH p.productPrices", Product.class);

        List<Product> products = query.getResultList();


        for (Product product : products) {
            Hibernate.initialize(product.getProductImageList());
        }

        return products;
    }


    public void setStatus(Product product, ProductStatus productStatus){
        product.setStatus(productStatus);
    }
    public List<Product> getActiveProduct(){
        return em.createNamedQuery("Product.findAll", Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }
    public void updateStatus(long id, ProductStatus productStatus){
        EntityTransaction tr = em.getTransaction();
        TypedQuery<Product> query = em.createNamedQuery("Product.findById", Product.class)
                .setParameter(1, id);
        Product product = query.getSingleResult();
        product.setStatus(productStatus);
        try {
            tr.begin();
            em.merge(product);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            logger.info(e.getMessage());
        }
    }
    public List<Cart> getCartProducts(ArrayList<Cart> cartlist){

        List<Cart> result = new ArrayList<Cart>();

        try {

            if(cartlist!= null && !cartlist.isEmpty()){
                for (Cart item: cartlist){
                    System.out.println("ank nak---------------------------------"+item.getId());
                    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class);
                    query.setParameter("id", item.getId());
                    List<Product> products = query.getResultList();
                    if(!products.isEmpty()){
                        Product product = products.get(0);
                        TypedQuery<ProductPrice> priceQuery = em.createQuery(
                                "SELECT pp FROM ProductPrice pp WHERE pp.product = :product ORDER BY pp.priceDateTime DESC", ProductPrice.class);
                        priceQuery.setParameter("product", product);
                        priceQuery.setMaxResults(1);

                        List<ProductPrice> priceResult = priceQuery.getResultList();
                        if(!priceResult.isEmpty()){
                            ProductPrice latestPrice = priceResult.get(0);
                            Cart row = new Cart();
                            row.setId(product.getId());
                            row.setName(product.getName());
                            row.setDescription(product.getDescription());
                            row.setUnit(product.getUnit());
                            row.setManufacturerName(product.getManufacturerName());
                            row.setStatus(product.getStatus());
                            row.setQuantity(item.getQuantity());
                            row.setTotalPrice(latestPrice.getPrice() * item.getQuantity());

                            result.add(row);
                        }

                    }
                }
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return result;
    }
    public double getTotalCartPrice(ArrayList<Cart> cartList){
        double sum = 0;

        try {
            if(cartList.size()>0){
                for (Cart item : cartList){
                    TypedQuery<Product> productQuery = em.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class);
                    productQuery.setParameter("id", item.getId());
                    List<Product> products = productQuery.getResultList();
                    if (!products.isEmpty()) {
                        Product product = products.get(0);
                        TypedQuery<ProductPrice> priceQuery = em.createQuery(
                                "SELECT pp FROM ProductPrice pp WHERE pp.product = :product ORDER BY pp.priceDateTime DESC", ProductPrice.class);
                        priceQuery.setParameter("product", product);
                        priceQuery.setMaxResults(1);

                        List<ProductPrice> priceResult = priceQuery.getResultList();
                        if (!priceResult.isEmpty()) {
                            ProductPrice latestPrice = priceResult.get(0);
                            double itemPrice = latestPrice.getPrice() * item.getQuantity();
                            sum += itemPrice;
                        }
                    }
                }
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return sum;
    }

}