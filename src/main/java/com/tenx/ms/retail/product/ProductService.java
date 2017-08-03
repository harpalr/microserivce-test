package com.tenx.ms.retail.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProductDetail(int product_id){
        Product product;
        product = productRepository.findOne(product_id);
        return product;
    }

    public Product getProductDetailByName(String productName){
        Product product;
        product = productRepository.findByProductName(productName);
        return product;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void updateProduct(int product_id, Product product){
        product.setProduct_id(product_id);
        productRepository.save(product);
    }

    public void deleteProduct(int product_id){
        productRepository.delete(product_id);
    }
}
