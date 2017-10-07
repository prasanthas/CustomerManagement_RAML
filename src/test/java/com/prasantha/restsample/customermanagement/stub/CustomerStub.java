package com.prasantha.restsample.customermanagement.stub;

import com.prasantha.restsample.customermanagement.domain.Address;
import com.prasantha.restsample.customermanagement.domain.Customer;

public class CustomerStub {

    public static Customer getCustomer1() {
        Customer customer = new Customer();
        customer.setFirstName("Pras");
        customer.setLastName("Siva");

        Address address = new Address();
        address.setHouseNumber("1");
        address.setStreetName(" Station st");
        address.setCity("Sydney");
        address.setPostCode("2140");

        customer.setAddress(address);



        return customer;
    }

    public static Customer getCustomer2() {
        Customer customer = new Customer();
        customer.setFirstName("Ravi");
        customer.setLastName("Sena");

        Address address = new Address();
        address.setHouseNumber("2");
        address.setStreetName(" Powel St");
        address.setCity("Parramatta");
        address.setPostCode("2222");

        customer.setAddress(address);

        return customer;
    }

}
