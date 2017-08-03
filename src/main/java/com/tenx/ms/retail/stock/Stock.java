package com.tenx.ms.retail.stock;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Stock implements Serializable {

    @EmbeddedId
    private StockMapping stockMapping;

    @Column(name = "count")
    private int count;

    public Stock() {
    }

    public Stock(int count){
        this.count = count;
    }

    public Stock(StockMapping stockMapping, int count){
        this.stockMapping = stockMapping;
        this.count = count;
    }

    public StockMapping getStockMapping() {
        return stockMapping;
    }

    public void setStockMapping(StockMapping stockMapping) {
        this.stockMapping = stockMapping;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
