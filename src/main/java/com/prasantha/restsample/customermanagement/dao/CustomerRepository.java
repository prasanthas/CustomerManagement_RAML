package com.prasantha.restsample.customermanagement.dao;

import com.prasantha.restsample.customermanagement.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

}
