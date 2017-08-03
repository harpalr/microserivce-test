package com.tenx.ms.retail.stock;

import com.tenx.ms.retail.RetailServiceApp;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RetailServiceApp.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyUpdateStock() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/stock/add/1/1/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"count\" : \"10\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.store_id").exists())
                .andExpect(jsonPath("$.product_id").exists())
                .andExpect(jsonPath("$.store_id").value(1))
                .andExpect(jsonPath("$.product_id").value(1))
                .andDo(print());
    }


}
