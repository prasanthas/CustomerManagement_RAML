package com.prasantha.restsample.customermanagement.service;


import com.prasantha.restsample.customermanagement.domain.Order;
import com.prasantha.restsample.customermanagement.domain.Product;
import com.prasantha.restsample.customermanagement.stub.ProductBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderBuilder {

    public static Order createOrder1() {
        Order order = new Order();

        order.setOrderDetails("O1");
        Product p1 = ProductBuilder.createProduct1("p1");
        Product p2 = ProductBuilder.createProduct1("p2");
        Set<Product> products = new HashSet<>();
        products.add(p1);
        products.add(p2);
        order.setProducts(products);
        return order;
    }

    public static Order createOrder2() {
        Order order = new Order();

        order.setOrderDetails("O2");
        Product p1 = ProductBuilder.createProduct1("p11");
        Product p2 = ProductBuilder.createProduct1("p22");
        Set<Product> products = new HashSet<>();
        products.add(p1);
        products.add(p2);
        order.setProducts(products);
        return order;
    }


}
