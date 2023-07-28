package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    // CREATE
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomerRecord(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    // READ ALL
    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }

    // READ By id
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = repo.findById(id);

        if (returnVal.isPresent()) {
            return returnVal.get();
        }
        else {
            return null;
        }
    }
    // UPDATE
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerRecord(@RequestBody Customer customer){
        repo.save(customer);
    }

    // Delete by id
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable int id){
        repo.deleteById(id);
    }

    // Filter by state
    @GetMapping("/customers/state/{state}")
    public List<Customer> getAllByState(String state){
        return repo.findAllByState(state);
    }
}
