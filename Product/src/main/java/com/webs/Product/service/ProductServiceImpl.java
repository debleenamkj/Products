package com.webs.Product.service;

import com.webs.Product.exception.ProductAlreadyExistException;
import com.webs.Product.exception.ProductNotFoundException;
import com.webs.Product.model.ChargesOutput;
import com.webs.Product.model.Product;
import com.webs.Product.model.ProductCategory;
import com.webs.Product.model.ProductOutput;
import com.webs.Product.repository.ProductCategoryRepository;
import com.webs.Product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository){
        log.info("Autowiring ProductServiceImpl Done");
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product){
        log.debug("Inside ProductServiceImpl - createProduct");
        try {
            if (!(productRepository.findById(product.getProductId()).isEmpty())) {
                log.error("Inside ProductServiceImpl - createProduct - ProductAlreadyExistException");
                throw new ProductAlreadyExistException();
            }
            productRepository.save(product);
        } catch (ProductAlreadyExistException e){
            e.getMessage();
            log.error("In createProduct of ProductServiceImpl"+e);
        }
        catch (Exception e){
            log.error("In createProduct of ProductServiceImpl"+e);
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory product) {
        log.debug("Inside ProductServiceImpl - createProductCategory");
        productCategoryRepository.save(product);
        return product;
    }

    @Override
    public List<ProductCategory> getAllProductCategory(){
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductOutput getProduct(Long productId) {
        log.debug("Inside ProductServiceImpl - getProduct");
        Product product = productRepository.findById(productId).get();
        ProductOutput productOutput = new ProductOutput();
        ChargesOutput chargesOutput = new ChargesOutput();
        try {
            if (productRepository.findById(productId).isEmpty()) {
                log.error("Inside ProductServiceImpl - getProduct - ProductNotFoundException");
                throw new ProductNotFoundException();
            }
            productOutput.setProductId(product.getProductId());
            productOutput.setName(product.getName());
            productOutput.setProductType(product.getProductType());
            productOutput.setCategory(product.getProductCategory());
            productOutput.setBasePrice(product.getProductPrice());
            double discount = 0;
            double gst = 0;
            ProductCategory productCategory = productCategoryRepository.findById(product.getProductCategory()).get();
            if (product.getProductCategory().equals(productCategory.getProductCategory())) {
                discount = (product.getProductPrice() * productCategory.getDiscount()) / 100;
                productOutput.setDiscount(discount);
                gst = ((product.getProductPrice() - discount) * 18) / 100;
                chargesOutput.setGst(gst);

            }
            double delivery = productCategory.getDeliveryCharges();
            chargesOutput.setDelivery(delivery);
            productOutput.setCharges(chargesOutput);
            double finalPrice = product.getProductPrice() - discount + gst + delivery;
            productOutput.setFinalPrice(finalPrice);
        } catch (ProductNotFoundException e){
            e.getMessage();
            log.error("In createProductCategory of ProductServiceImpl"+e);
        }
        catch (Exception e){
            log.error("In createProductCategory of ProductServiceImpl"+e);
            e.printStackTrace();
        }
        return productOutput;
    }

    @Override
    public List<ProductOutput> getProducts() {
        log.debug("Inside ProductServiceImpl - getProducts");
        List<Product> product1 = productRepository.findAll();
        List<ProductOutput> productOutput1 = new ArrayList<>();
        for(Product product: product1) {
            ProductOutput productOutput = new ProductOutput();
            ChargesOutput chargesOutput = new ChargesOutput();
            productOutput.setProductId(product.getProductId());
            productOutput.setName(product.getName());
            productOutput.setProductType(product.getProductType());
            productOutput.setCategory(product.getProductCategory());
            productOutput.setBasePrice(product.getProductPrice());
            double discount = 0;
            double gst = 0;
            ProductCategory productCategory = productCategoryRepository.findById(product.getProductCategory()).get();
            if (product.getProductCategory().equals(productCategory.getProductCategory())) {
                discount = (product.getProductPrice() * productCategory.getDiscount()) / 100;
                productOutput.setDiscount(discount);
                gst = ((product.getProductPrice() - discount) * 18) / 100;
                chargesOutput.setGst(gst);

            }
            double delivery = productCategory.getDeliveryCharges();
            chargesOutput.setDelivery(delivery);
            productOutput.setCharges(chargesOutput);
            double finalPrice = product.getProductPrice() - discount + gst + delivery;
            productOutput.setFinalPrice(finalPrice);
            productOutput1.add(productOutput);
        }
        return productOutput1;
    }

    @Override
    public Product updateProduct(Product product) {
        log.debug("Inside ProductServiceImpl - updateProduct");
        try {
            if (productRepository.findById(product.getProductId()).isEmpty()) {
                log.error("Inside ProductServiceImpl - updateProduct - ProductNotFoundException");
                throw new ProductNotFoundException();
            }
        }
        catch (ProductNotFoundException e){
            e.getMessage();
            log.error("In updateProduct of ProductServiceImpl"+e);
        }
        catch (Exception e){
            log.error("In updateProduct of ProductServiceImpl"+e);
            e.printStackTrace();
        }
        return productRepository.save(product);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        log.debug("Inside ProductServiceImpl - updateProductCategory");
        try {
            if (productCategoryRepository.findById(productCategory.getProductCategory()).isEmpty()) {
                log.error("Inside ProductServiceImpl - updateProductCategory - ProductNotFoundException");
                throw new ProductNotFoundException();
            }
        }
        catch (ProductNotFoundException e){
            log.error("In updateProductCategory of ProductServiceImpl"+e);
            e.getMessage();
        }
        catch (Exception e){
            log.error("In updateProductCategory of ProductServiceImpl"+e);
            e.printStackTrace();
        }
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public Product deleteProduct(Long productId){
        log.debug("Inside ProductServiceImpl - deleteProduct");
        Product product = productRepository.findById(productId).get();
        try {
            if (productRepository.findById(productId).isEmpty()) {
                log.error("Inside ProductServiceImpl - deleteProduct - ProductNotFoundException");
                throw new ProductNotFoundException();
            }
            productRepository.deleteById(productId);
        }
        catch (ProductNotFoundException se){
            log.error("In deleteProduct of ProductServiceImpl"+se);
            se.getMessage();
        }
        catch (Exception e){
            log.error("In deleteProduct of ProductServiceImpl"+e);
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public ProductCategory deleteProductCategory(String productCatId){
        log.debug("Inside ProductServiceImpl - deleteProduct");
        ProductCategory product = productCategoryRepository.findById(productCatId).get();
        try {
            if (productCategoryRepository.findById(productCatId).isEmpty()) {
                log.error("Inside ProductServiceImpl - deleteProduct - ProductNotFoundException");
                throw new ProductNotFoundException();
            }
            productCategoryRepository.deleteById(productCatId);
        }
        catch (ProductNotFoundException se){
            log.error("In deleteProduct of ProductServiceImpl"+se);
            se.getMessage();
        }
        catch (Exception e){
            log.error("In deleteProduct of ProductServiceImpl"+e);
            e.printStackTrace();
        }
        return product;
    }
}
