package com.webs.Product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webs.Product.model.Product;
import com.webs.Product.model.ProductOutput;
import com.webs.Product.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    private ProductServiceImpl service;

    @InjectMocks
    private ProductController controller;

    private Product product;

    @BeforeEach
    void setUp() throws Exception {
        product = new Product(100000001l, "abc", "abc", "abc", 5000.00);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void saveProductTest() throws Exception {
        when(service.createProduct(any())).thenReturn(product);
        mockMvc.perform(
                        post("/api/v1/saveproduct")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonToString(product))
                )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()
                );
        verify(service,times(1)).createProduct(any());
    }

    @Test
    public void getProductTest() throws Exception {
        List<ProductOutput> productOutputList = new ArrayList<>();
        ProductOutput productOutput = new ProductOutput();
        productOutputList.add(productOutput);
        when(service.getProducts()).thenReturn(productOutputList);
        mockMvc.perform(
                        get("/api/v1/getProducts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonToString(product))
                ).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        productOutputList.clear();

    }

    @Test
    public void updateProduct() throws Exception{
        when(service.updateProduct(any())).thenReturn(product);
        mockMvc.perform(
                        put("/api/v1/updateproduct")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonToString(product))
                ).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteSkillTrendTest() throws Exception{
        when(service.deleteProduct(anyLong())).thenReturn(product);
        mockMvc.perform(
                delete("/api/v1/deleteproduct/"+product.getProductId())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    public static String jsonToString(final Object obj)throws JsonProcessingException
    {
        String result=null;

        try
        {
            ObjectMapper mapper=new ObjectMapper();
            String jsonContent=mapper.writeValueAsString(obj);
            result=jsonContent;
        }
        catch(JsonProcessingException e)
        {
            result="Json Processing Error";
        }
        return result;
    }
}
