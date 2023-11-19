package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductImage;

public class ProductImageRepository extends GenericCRUD<ProductImage> {
    public ProductImageRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
}
