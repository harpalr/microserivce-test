package com.tenx.ms.retail.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public StockMapping updateStock(int productId, int storeId, Stock stock){
        Stock stockEntity = new Stock();
        StockMapping stockMapping = new StockMapping(storeId, productId);
        stockEntity.setStockMapping(stockMapping);
        stockEntity.setCount(stock.getCount());
        return stockRepository.save(stockEntity).getStockMapping();
    }

}
