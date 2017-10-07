package com.prasantha.restsample.customermanagement.service;

import com.prasantha.restsample.customermanagement.dao.CustomerRepository;
import com.prasantha.restsample.customermanagement.domain.Customer;
import com.prasantha.restsample.customermanagement.stub.CustomerBuilder;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("resource/customerservice")
public class CustomerManagementService {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(path = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> listCustomers() {

        List<Customer> customers = StreamSupport.stream(customerRepository.findAll().spliterator(), false).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(customers)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @RequestMapping(path = "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerRepository.findOne(customerId);
    }

    @RequestMapping("/addCustomer")
    public void insertCustomer() {
        Customer customer = CustomerBuilder.getCustomer1();

        customerRepository.save(customer);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @RequestMapping(path = "{customerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteCustomer() {

    }

}
