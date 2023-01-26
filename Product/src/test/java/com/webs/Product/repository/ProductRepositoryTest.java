package com.webs.Product.repository;

import com.webs.Product.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() throws Exception {
        product = new Product(100000001l, "abc", "abc", "abc", 5000.00);
    }

    @AfterEach
    void tearDown() throws Exception {
        productRepository.deleteById(100000001L);
    }

    @Test
    public void testInsertionOfSkillTrend() {

        productRepository.insert(product);
        Product product1 = productRepository.findById(product.getProductId()).get();
        assertEquals(product1.getProductId(), product.getProductId());
    }

    @Test
    public void testSaveSkillTrend() {
        productRepository.save(product);
        Product product1 = productRepository.findById(product.getProductId()).get();
        assertEquals(product1.getProductId(), product.getProductId());
    }

    @Test
    public void testDeleteSkillTrend() {
        productRepository.insert(product);
        Product product1 = productRepository.findById(product.getProductId()).get();
        productRepository.deleteById(product1.getProductId());
        assertEquals(Optional.empty(), productRepository.findById(product.getProductId()));
    }

    @Test
    public void testRetrieveData() {
        productRepository.insert(product);
        assertEquals("abc",product.getProductCategory());
    }

    @Test
    public void testExistingData() {
        productRepository.insert(product);
        assertTrue(productRepository.existsById(product.getProductId()));
    }

    @Test
    public void testNegativeInsertionOfSkillTrend() {
        productRepository.insert(product);
        Product product1 = new Product(100000123l, "abc", "abc", "abc", 5000.00);
        assertNotEquals(product1.getProductId(), product.getProductId());
        productRepository.deleteById(100000123l);
    }

    @Test
    public void testNegativeSaveSkillTrend() {
        productRepository.save(product);
        Product product1 = new Product(100000123l, "abc", "abc", "abc", 5000.00);
        assertNotEquals(product1.getProductId(), product.getProductId());
        productRepository.deleteById(100000123l);
    }

    @Test
    public void testNegativeDeleteSkillTrend() {
        productRepository.insert(product);
        Product product1 = productRepository.findById(product.getProductId()).get();
        productRepository.deleteById(product1.getProductId());
        assertNotEquals(null, productRepository.findById(product.getProductId()));
    }

    @Test
    public void testNegativeRetrieveData() {
        productRepository.insert(product);
        assertNotEquals(null,product.getProductCategory());
    }

    @Test
    public void testNegativeExistingData() {
        productRepository.insert(product);
        assertFalse(productRepository.existsById(0000000000000000000000000000l));
    }

}
