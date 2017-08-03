package com.tenx.ms.retail.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    public Product findByProductName (String productName);

}
