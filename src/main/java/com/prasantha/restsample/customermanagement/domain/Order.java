package com.prasantha.restsample.customermanagement.domain;

import javax.persistence.Entity;
import java.util.Set;

//@Entity
public class Order {

    private Long id;
    private String orderDetails;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Product> products;

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDetails='" + orderDetails + '\'' +
                ", products=" + products +
                '}';
    }
}
