package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;


import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Order;

public class OrderRepository extends GenericCRUD<Order> {
    public OrderRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
}
