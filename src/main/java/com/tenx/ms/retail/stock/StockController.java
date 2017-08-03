package com.tenx.ms.retail.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(method = RequestMethod.POST, value = "/stock/add/{store_id}/{product_id}")
    public StockMapping updateStock(@PathVariable("product_id") int product_id, @PathVariable("store_id") int store_id, @RequestBody Stock stock){
        return stockService.updateStock(product_id, store_id, stock);
    }

}
