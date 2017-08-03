package com.tenx.ms.retail.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("/product/detail/id/{product_id}")
    public Product getProductDetail(@PathVariable ("product_id") int product_id){
        return productService.getProductDetail(product_id);
    }

    @RequestMapping("/product/detail/name/{product_name}")
    public Product getProductDetailByName(@PathVariable ("product_name") String product_name){
        return productService.getProductDetailByName(product_name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product/update/{product_id}")
    public void updateProduct(@PathVariable("product_id") int product_id, @RequestBody Product product){
        productService.updateProduct(product_id, product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/delete/{product_id}")
    public void deleteProduct(@PathVariable int product_id){
        productService.deleteProduct(product_id);
    }
}
