package com.tenx.ms.retail.stock;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface StockRepository extends CrudRepository<Stock, StockMapping> {

    public Stock findByStockMapping(StockMapping stockMapping);

}
