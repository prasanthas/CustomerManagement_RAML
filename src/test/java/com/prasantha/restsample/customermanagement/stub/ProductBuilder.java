package com.prasantha.restsample.customermanagement.stub;


import com.prasantha.restsample.customermanagement.domain.Product;

public class ProductBuilder {

    public static Product createProduct1(String productName) {
        Product product = new Product();
        product.setProductName(productName);
        return product;
    }

}
