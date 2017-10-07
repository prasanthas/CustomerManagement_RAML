package com.prasantha.restsample.customermanagement.domain;

import javax.persistence.Entity;

//@Entity
public class Product {

    private Long id;
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
