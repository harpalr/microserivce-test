package com.tenx.ms.retail.store;

import com.tenx.ms.retail.RetailServiceApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RetailServiceApp.class)
@SpringBootTest
public class StoreControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyAllStores() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/store/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(8)))
                .andDo(print());
    }

    @Test
    public void verifyProductDetail() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/store/detail/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.store_id").exists())
                .andExpect(jsonPath("$.store_name").exists())
                .andDo(print());
    }

    @Test
    public void verifyAddStore() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/store/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"store_name\" : \"ACE Electronics\", \"active\": 1 }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.store_name").exists())
                .andDo(print());
    }
}
