package com.webs.Product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    @Id
    Long productId;
    String name;
    String productType;
    String productCategory;
    double productPrice;
}
