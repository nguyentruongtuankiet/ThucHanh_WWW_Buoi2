package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.converters.ProductStatusConverter;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.ProductStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p WHERE p.status = ?1"),
        @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = ?1"),
        @NamedQuery(name = "Product.updateStatus", query = "UPDATE Product roduct SET status = :status WHERE id = :id")
})

public class Product implements Serializable {
    //product (product_id, name, description, unit, manufacturer_name, status)
    @Id
    @Column(name = "product_id", columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String unit;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Convert(converter = ProductStatusConverter.class)
    @Column(columnDefinition = "INT(11)")
    private ProductStatus status;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImage> productImageList = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductPrice> productPrices = new ArrayList<>();


    public Product() {

    }

    public Product(long id, String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }


    public Product(String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", status=" + status +
                ", productImageList=" + productImageList +
                ", orderDetails=" + orderDetails +
                ", productPrices=" + productPrices +
                '}';
    }
}