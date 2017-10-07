package com.prasantha.restsample.customermanagement.stub;

import com.prasantha.restsample.customermanagement.domain.Address;
import com.prasantha.restsample.customermanagement.domain.Customer;

public class CustomerBuilder {

    public static Customer getCustomer1() {
        Customer customer = new Customer();
        customer.setFirstName("firstName1");
        customer.setLastName("lastName1");

        Address address = new Address();
        address.setHouseNumber("1");
        address.setStreetName(" st name 1");
        address.setCity("Sydney");
        address.setPostCode("2140");

        customer.setAddress(address);



        return customer;
    }

    public static Customer getCustomer2() {
        Customer customer = new Customer();
        customer.setFirstName("firstName2");
        customer.setLastName("lastName2");

        Address address = new Address();
        address.setHouseNumber("2");
        address.setStreetName(" st name 1");
        address.setCity("Parramatta");
        address.setPostCode("2222");

        customer.setAddress(address);

        return customer;
    }

}
