package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services;


import jakarta.inject.Inject;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductPrice;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ProductPriceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceServices {

    @Inject
    private ProductPriceRepository productPriceRepository;

    @Inject
    public ProductPriceServices() {
        this.productPriceRepository = new ProductPriceRepository();
    }

    public boolean addProductPrice(ProductPrice productPrice) {
        return productPriceRepository.addProductPrice(productPrice);
    }

    public boolean deleteProductPrice(long productId, LocalDateTime priceDateTime) {
        return productPriceRepository.deleteProductPrice(productId, priceDateTime);
    }

    public Optional<ProductPrice> getProductPriceById(long productId, LocalDateTime priceDateTime) {
        return productPriceRepository.getProductPriceById(productId, priceDateTime);
    }

    public List<ProductPrice> getAll() {
        return productPriceRepository.getAll();
    }

    public Double getNewPriceByIdProduct(String product_id) {
        return productPriceRepository.getNewPriceByIdProduct(product_id);
    }


}
