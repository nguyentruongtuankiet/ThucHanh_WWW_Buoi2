package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "product_price")

@NamedQueries({
        @NamedQuery(name = "ProductPrice.getProductNewPrice", query = "FROM ProductPrice WHERE product.id = :productId order by priceDateTime desc")
})
public class ProductPrice {

    @Id
//    @JsonbDateFormat(value = "yyyy-MM-dd")
    @Column(name = "price_date_time", columnDefinition = "datetime(6)")
    private LocalDateTime priceDateTime;

    private String note;

    private double price;

    @JsonBackReference
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", columnDefinition = "bigint(20)")
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime priceDateTime, String note, double price, Product product) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
        this.product = product;
    }

    public ProductPrice(LocalDateTime priceDateTime, Product product) {
        this.priceDateTime = priceDateTime;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(priceDateTime, that.priceDateTime) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceDateTime, product);
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }
}
