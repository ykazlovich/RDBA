package com.rdba.web.controller;

import com.rdba.OrderTestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.rdba.OrderTestData.contentJsonIterable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static com.rdba.OrderTestData.contentJson;

@SpringJUnitWebConfig(locations = {
        "classpath:hibernate.cfg.xml",
        "classpath:spring.xml",
        "classpath:dispatcher-servlet.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRestControllerTest {


    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(get("/v1/orders/1"))
                .andExpect(status().isOk())
                //.andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(contentJson(OrderTestData.orderCheck1));
    }

    @Test
    public void getAllOrder() throws Exception {
        mockMvc.perform(get("/v1/orders/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(contentJsonIterable(OrderTestData.allOrder));
    }
}