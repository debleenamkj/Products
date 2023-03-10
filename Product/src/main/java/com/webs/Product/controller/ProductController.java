package com.webs.Product.controller;

import com.webs.Product.model.Product;
import com.webs.Product.model.ProductCategory;
import com.webs.Product.model.ProductOutput;
import com.webs.Product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin
public class ProductController {
    private ProductServiceImpl productService;
    @Autowired
    public ProductController(ProductServiceImpl productService){
        log.info("Autowiring ProductController Done");
        this.productService = productService;
    }
    @PostMapping("/saveproduct")
    public Product createProduct(@RequestBody Product product) {
        log.debug("Inside ProductController - createProduct");
        return productService.createProduct(product);
    }
    @PostMapping("/saveproductcategory")
    public ResponseEntity<?> createProductCategory(@RequestBody ProductCategory product) {
        log.debug("Inside ProductController - createProductCategory");
        productService.createProductCategory(product);
        return new ResponseEntity<>("Product Category Created", HttpStatus.CREATED);
    }

    @GetMapping("/getproduct/{productId}")
    public ProductOutput getProduct(@PathVariable Long productId) {
        log.debug("Inside ProductController - getProduct");
        return productService.getProduct(productId);
    }

    @GetMapping("/getProducts")
    public List<ProductOutput> getAllProducts() {
        log.debug("Inside ProductController - getAllProducts");
        return productService.getProducts();
    }

    @GetMapping("/getproductcategory")
    public List<ProductCategory> getAllProductCategory() {
        log.debug("Inside ProductController - getAllProductCategory");
        return productService.getAllProductCategory();
    }

    @PutMapping("/updateproduct")
    public Product updateProduct(@RequestBody Product product){
        log.debug("Inside ProductController - updateProduct");
        return productService.updateProduct(product);
    }

    @PutMapping("/updateproductcategory")
    public ProductCategory updateProductCategory(@RequestBody ProductCategory product){
        log.debug("Inside ProductController - updateProductCategory");
        return productService.updateProductCategory(product);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public Product deleteProduct(@PathVariable Long productId){
        log.debug("Inside ProductController - deleteProduct");
        return productService.deleteProduct(productId);
    }

    @DeleteMapping("/deleteproductcategory/{productCategoryId}")
    public ProductCategory deleteProduct(@PathVariable String productCategoryId){
        log.debug("Inside ProductController - deleteProduct");
        return productService.deleteProductCategory(productCategoryId);
    }
}

