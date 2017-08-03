package com.tenx.ms.retail.product;

import com.sun.jdi.DoubleValue;
import com.tenx.ms.retail.product.Product;
import com.tenx.ms.retail.product.ProductRepository;
import com.tenx.ms.retail.product.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllProducts(){

        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product("WIRE", "RJ 45 Cable", BigDecimal.valueOf(10.99), "Used for Internet", true));
        productsList.add(new Product("HDD", "Segate", BigDecimal.valueOf(24.99), "Used for storing data", true));
        productsList.add(new Product("FDD", "RJ 45 Cable", BigDecimal.valueOf(12.00), "Used for smaller storage", true));

        when(productRepository.findAll()).thenReturn(productsList);
        List<Product> result = productService.getAllProducts();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetProductDetail(){
        Product product = new Product(1,"WIRE", "RJ 45 Cable", BigDecimal.valueOf(10.99), "Used for Internet", true);
        when(productRepository.findOne(1)).thenReturn(product);
        Product result = productService.getProductDetail(1);
        assertEquals(BigDecimal.valueOf(10.99), result.getPrice());
    }

    @Test
    public void testGetProductDetailByName(){
        Product product = new Product(1,"WIRE", "RJ 45 Cable", BigDecimal.valueOf(10.99), "Used for Internet", true);
        when(productRepository.findByProductName("RJ 45 Cable")).thenReturn(product);
        Product result = productService.getProductDetailByName("RJ 45 Cable");
        assertEquals(BigDecimal.valueOf(10.99), result.getPrice());
    }

    @Test
    public void testAddProduct(){
        Product product = new Product(1,"WIRE", "RJ 45 Cable", BigDecimal.valueOf(10.99), "Used for Internet", true);
        when(productRepository.save(product)).thenReturn(product);
        Product result = productService.addProduct(product);
        assertEquals(BigDecimal.valueOf(10.99), result.getPrice());
        assertEquals("RJ 45 Cable", result.getProductName());
    }

    @Test
    public void testDeleteProduct(){
        Product product = new Product(1,"WIRE", "RJ 45 Cable", BigDecimal.valueOf(10.99), "Used for Internet", true);
        productService.deleteProduct(1);
        verify(productRepository, times(1)).delete(1);
    }

}
