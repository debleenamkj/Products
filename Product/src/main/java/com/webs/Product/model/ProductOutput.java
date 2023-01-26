package com.webs.Product.model;

import lombok.Data;

@Data
public class ProductOutput {
    Long productId;
    String name;
    String productType;
    String category;
    double basePrice;
    double discount;
    ChargesOutput charges;
    double finalPrice;
}
