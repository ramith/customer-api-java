package com.wso2.choreo.demo;

import com.wso2.choreo.demo.model.Customer;
import com.wso2.choreo.demo.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerRestController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/{accountId}")
    public @ResponseBody Customer findCustomerById(@PathVariable("accountId") String accountId) {

        logger.info("finding customer by id: " + accountId);

        Optional<Customer> customerOptional = customerRepository.findById(accountId);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
        } else {
            return customerOptional.get();


        }
    }

}
