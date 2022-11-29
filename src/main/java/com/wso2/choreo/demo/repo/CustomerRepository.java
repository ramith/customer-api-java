package com.wso2.choreo.demo.repo;


import com.wso2.choreo.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
