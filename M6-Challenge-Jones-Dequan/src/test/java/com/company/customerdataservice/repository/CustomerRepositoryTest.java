package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repo;

    @BeforeEach
    public void setUp() throws Exception{
        repo.deleteAll();
    }

    @Test
    public void addCustomer(){
        // ARRANGE
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12344 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("California");
        customer.setCountry("United States");
        customer.setPostalCode("12345");

        customer = repo.save(customer);

        // ACT - Add the customer
        Customer newCust = new Customer();
        newCust.setId(customer.getId());
        newCust = repo.save(newCust);

        // Assert - find newly created customer in database if possible
        Optional<Customer> cust = repo.findById(newCust.getId());

        // Results should be equal if the customer was successfully added
        assertEquals(cust.get(), newCust); //
    }

}