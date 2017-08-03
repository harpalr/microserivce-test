package com.tenx.ms.retail.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int product_id;
    private String sku;
    @Column(name = "product_name")
    private String productName;
    private BigDecimal price;
    @Lob
    @Column(name = "product_description", columnDefinition = "text")
    private String product_description;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean active;

    public Product() {
    }

    public Product(
            String sku,
            String productName,
            BigDecimal price,
            String product_description,
            boolean active) {
        super();
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.product_description = product_description;
        this.active = active;
    }

    public Product(
            int product_id,
            String sku,
            String productName,
            BigDecimal price,
            String product_description,
            boolean active) {
        super();
        this.product_id = product_id;
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.product_description = product_description;
        this.active = active;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
