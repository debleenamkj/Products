package com.webs.Product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductCategory {
    @Id
    String productCategory;
    double discount;
    double gst;
    double deliveryCharges;
}
