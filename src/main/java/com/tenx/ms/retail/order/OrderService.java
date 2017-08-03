package com.tenx.ms.retail.order;

import com.tenx.ms.retail.product.Product;
import com.tenx.ms.retail.product.ProductController;
import com.tenx.ms.retail.product.ProductRepository;
import com.tenx.ms.retail.stock.Stock;
import com.tenx.ms.retail.stock.StockMapping;
import com.tenx.ms.retail.stock.StockRepository;
import com.tenx.ms.retail.store.Store;
import com.tenx.ms.retail.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StockRepository stockRepository;

    private List<Stock> stockList = new ArrayList<Stock>();

    public Orders processOrder(Orders order) throws Exception {

        Orders orderEntity = new Orders();

        Store store = storeRepository.findOne(order.getStore_id());
        if(store == null){
            throw new Exception("Store Id " + order.getStore_id() + " not found.");
        }

        orderEntity.setStore_id(order.getStore_id());
        orderEntity.setCustomer_id(order.getCustomer_id());
        orderEntity.setStatus(order.getStatus());

        List<OrderDetails> orderDetailsSet = order.getOrder_detail();
        Iterator<OrderDetails> iteratorOrderSet = orderDetailsSet.iterator();
        while(iteratorOrderSet.hasNext()){
            OrderDetails orderDetails = new OrderDetails();
            OrderDetails orderDetailsData = iteratorOrderSet.next();

            Product product = productRepository.findOne(orderDetailsData.getProduct_id());
            if(product == null){
                throw new Exception("Product Id " + orderDetailsData.getProduct_id() + " not found.");
            }

            orderDetails.setProduct_id(orderDetailsData.getProduct_id());
            orderDetails.setQuantity(orderDetailsData.getQuantity());
            orderDetails.setTotal_amount(orderDetailsData.getTotal_amount());
            orderDetails.setOrder(orderEntity);

            orderEntity.addOrder_detail(orderDetails);
            this.updateStock(order.getStore_id(), orderDetailsData.getProduct_id(), orderDetailsData.getQuantity());
        }
        return orderRepository.save(orderEntity);
    }

    private void updateStock(int store_id, int product_id, int quantity) throws Exception{
        StockMapping stockMapping = new StockMapping(store_id, product_id);
        Stock stock = stockRepository.findByStockMapping(stockMapping);
        if(stock != null){
            if(stock.getCount() >= quantity){
                stock.setCount(stock.getCount() - quantity);
                this.stockList.add(stock);
            } else {
                throw new Exception("Not enough stock in inventory for product id " + product_id + " and Store id " + store_id);
            }
        } else {
            throw new Exception("No Stock for product id " + product_id + " and Store id " + store_id);
        }
    }


}
