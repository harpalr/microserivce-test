package com.tenx.ms.retail.product;

import com.tenx.ms.retail.RetailServiceApp;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RetailServiceApp.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyAllProducts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/product/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(7)))
                .andDo(print());
    }

    @Test
    public void verifyProductDetail() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/product/detail/id/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product_id").exists())
                .andExpect(jsonPath("$.sku").exists())
                .andExpect(jsonPath("$.product_name").exists())
                .andExpect(jsonPath("$.product_description").exists())
                .andDo(print());
    }

    @Test
    public void verifyProductDetailByName() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/product/detail/name/Mac i7 Laptop")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product_id").exists())
                .andExpect(jsonPath("$.sku").exists())
                .andExpect(jsonPath("$.product_name").exists())
                .andExpect(jsonPath("$.product_description").exists())
                .andDo(print());
    }

    @Test
    public void verifyAddProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/product/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"sku\" : \"IPAD\", \"product_name\": \"Apple iPad\", \"price\" : \"800.00\", \"product_description\" : \"Apple iPad good for business\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product_id").exists())
                .andExpect(jsonPath("$.sku").exists())
                .andExpect(jsonPath("$.product_name").exists())
                .andExpect(jsonPath("$.product_description").exists())
                .andDo(print());
    }
}
