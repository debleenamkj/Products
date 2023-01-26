package com.webs.Product.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.webs.Product.model.Product;
import com.webs.Product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepo;

    @InjectMocks
    ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() throws Exception {
        product = new Product(100000001l, "abc", "abc", "abc", 5000.00);
    }

    @Test
    public void saveProductsTest() {
        when(productRepo.save(any())).thenReturn(product);
        assertEquals(product, productService.createProduct(product));
    }

    @Test
    public void getAllProductsTest() {
        List<Product> productList = new ArrayList<>();
        when(productRepo.findAll()).thenReturn(productList);
        assertEquals(0, productService.getProducts().size());
        productList.clear();
    }

    @Test
    public void saveProductsNegativeTest() {
        when(productRepo.save(any())).thenReturn(product);
        assertNotEquals(null, productService.createProduct(product));
    }

    @Test
    public void getAllProductsNegativeTest() {
        List<Product> productList = new ArrayList<>();
        when(productRepo.findAll()).thenReturn(productList);
        assertNotEquals(2, productService.getProducts().size());
        productList.clear();
    }

    @Test
    public void updateProductNegativeTest() {
        productRepo.deleteById(product.getProductId());
        verify(productRepo).deleteById(product.getProductId());
        when(productRepo.save(product)).thenReturn(product);
        assertNotEquals(false, productService.updateProduct(product));
    }
}
