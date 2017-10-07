package com.prasantha.restsample.customermanagement.service;

import com.prasantha.restsample.customermanagement.dao.CustomerRepository;
import com.prasantha.restsample.customermanagement.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("resource/customerservice")
public class CustomerManagementService {

    @Autowired
    private CustomerRepository customerRepository;

    //http://localhost:8080/resource/customerservice/customer/list
    @RequestMapping(path = "/customer/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> listCustomers() {
        System.out.println("listCustomer called");

        List<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(), false).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(customers)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    //http://localhost:8080/resource/customerservice/customer/2
    @RequestMapping(path = "/customer/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        System.out.println("getCustomer Called");

        Customer customer = customerRepository.findOne(customerId);

        if (customer == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

//    @RequestMapping("/customer/addCustomer")
//    public void insertCustomer() {
//        Customer customer = CustomerBuilder.getCustomer1();
//
//        customerRepository.save(customer);
//    }

    @RequestMapping(path = "/customer/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        System.out.println("Add Customer called"+customer);

        customerRepository.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/customer/{customerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Long customerId,@RequestBody Customer customer) {
        System.out.println("updateCustomer Called");

        Customer existingCustomer = customerRepository.findOne(customerId);

        System.out.println("existingCustomer: "+existingCustomer);
        customer.setId(existingCustomer.getId());

        if (existingCustomer == null) {
            System.out.println("customer not found");
            new ResponseEntity(new String("Customer not found"), HttpStatus.NOT_FOUND);
        }

        customerRepository.save(customer);

        return new ResponseEntity<Customer>(existingCustomer,HttpStatus.OK);

    }

    @RequestMapping(path = "/customer/{customerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Long customerId) {
        System.out.println("deleteCustomer called");

        Customer existingCustomer = customerRepository.findOne(customerId);

        System.out.println("existingCustomer: "+existingCustomer);

        if (existingCustomer == null) {
            System.out.println("customer not found");
            new ResponseEntity(new String("Customer not found"), HttpStatus.NOT_FOUND);
        }

        customerRepository.delete(existingCustomer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
