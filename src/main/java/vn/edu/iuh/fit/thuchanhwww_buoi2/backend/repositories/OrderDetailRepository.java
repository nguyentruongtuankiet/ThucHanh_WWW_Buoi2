package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.OrderDetail;

public class OrderDetailRepository extends GenericCRUD<OrderDetail> {
    public OrderDetailRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
}
