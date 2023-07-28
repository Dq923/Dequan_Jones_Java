package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // filter customers by state - findAllByState?
    List<Customer> findAllByState(String state);

    // findByID() already exists

    // deleteById already exists

    // deleteAll already exists

}
