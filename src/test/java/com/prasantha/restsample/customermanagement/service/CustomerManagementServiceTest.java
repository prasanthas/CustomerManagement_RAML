package com.prasantha.restsample.customermanagement.service;

import com.prasantha.restsample.customermanagement.domain.Customer;
import org.junit.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerManagementServiceTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/resource/customerservice";

    @Test
    public void listCustomers() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> customers = restTemplate.getForObject(REST_SERVICE_URI + "/list", List.class);
        if(customers!=null){
            for(LinkedHashMap<String, Object> map : customers){
                System.out.println("User : id="+map.get("id")+", firstName="+map.get("firstName")+", LastName="+map.get("lastName")+", Address="+map.get("address"));;
            }
        }else{
            System.out.println("No user ");
        }
    }

}