package com.webs.Product.service;

import com.webs.Product.model.Product;
import com.webs.Product.model.ProductCategory;
import com.webs.Product.model.ProductOutput;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    ProductCategory createProductCategory(ProductCategory product);
    List<ProductCategory> getAllProductCategory();
    ProductOutput getProduct(Long productId);
    List<ProductOutput> getProducts();
    Product updateProduct(Product product);
    ProductCategory updateProductCategory(ProductCategory productCategory);
    Product deleteProduct(Long productId);
    ProductCategory deleteProductCategory(String productCatId);
}
