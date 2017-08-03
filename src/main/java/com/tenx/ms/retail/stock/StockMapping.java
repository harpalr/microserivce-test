package com.tenx.ms.retail.stock;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StockMapping implements Serializable{

    @Column(name = "store_id", nullable = false)
    private int storeId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    public StockMapping(){

    }

    public StockMapping(int storeId, int productId) {
        this.storeId = storeId;
        this.productId = productId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId(), getProductId());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof StockMapping)) return false;
        StockMapping that = (StockMapping) obj;
        return Objects.equals(getStoreId(), that.getStoreId()) &&
                Objects.equals(getProductId(), that.getProductId());
    }
}

