package com.prasantha.restsample.customermanagement.service;

import com.prasantha.restsample.customermanagement.domain.Customer;
import com.prasantha.restsample.customermanagement.stub.CustomerStub;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CustomerManagementServiceTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/resource/customerservice/customer/";

    @Test
    public void testAll() {
        listCustomers();
        createCustomer();
        listCustomers();
        updateCustomer();
        listCustomers();
        deleteCustomer();
        listCustomers();
    }

    @Test
    public void listCustomers() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> customers = restTemplate.getForObject(REST_SERVICE_URI + "list", List.class);
        if(customers!=null){
            for(LinkedHashMap<String, Object> map : customers){
                System.out.println("Customer : id="+map.get("id")+", firstName="+map.get("firstName")+", LastName="+map.get("lastName")+", Address="+map.get("address"));;
            }
        }else{
            System.out.println("No Customer ");
        }
    }

    @Test
    public void getCustomer(){
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(REST_SERVICE_URI+"/1", Customer.class);
        System.out.println(customer);
    }

    @Test
    public void createCustomer() {
        RestTemplate restTemplate = new RestTemplate();

        Customer customer = CustomerStub.getCustomer1();

        URI uri = restTemplate.postForLocation(REST_SERVICE_URI, customer, Customer.class);
        System.out.println("Location : "+uri.toASCIIString());

        customer = CustomerStub.getCustomer2();

        uri = restTemplate.postForLocation(REST_SERVICE_URI, customer, Customer.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    @Test
    public  void updateCustomer() {
        RestTemplate restTemplate = new RestTemplate();

        Customer customer = new Customer();
        customer.setFirstName("Ben");
        customer.setLastName("Smith");

        restTemplate.put(REST_SERVICE_URI+"/1", customer);

        System.out.println(customer);
    }

    @Test
    public void deleteCustomer() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/2");
    }

}