package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repo;

    @BeforeEach
    public void setUp() throws Exception{
        repo.deleteAll();
    }

    @Test
    public void shouldAddCustomer(){
        // ARRANGE
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("California");
        customer.setCountry("United States");
        customer.setPostalCode("12345");

        customer = repo.save(customer);

        // ACT - Add the customer

        // Assert - find newly created customer in database if possible
        Optional<Customer> cust = repo.findById(customer.getId());

        // Results should be equal if the customer was successfully added
        assertEquals(cust.get(), customer); //
    }

    @Test
    public void shouldUpdateCustomer(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("California");
        customer.setCountry("United States");
        customer.setPostalCode("12345");

        customer = repo.save(customer);

        // Act
        customer.setFirstName("Jimmy");
        customer.setLastName("Neutron");

        repo.save(customer);

        // Assert
        Optional<Customer> cust = repo.findById(customer.getId());

        assertEquals(cust.get(),customer);

    }

    @Test
    public void deleteCustomer(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("California");
        customer.setCountry("United States");
        customer.setPostalCode("12345");

        customer = repo.save(customer);

        // Act
        Optional<Customer> cust = repo.findById(customer.getId());

        // Assert
        assertEquals(cust.get(), customer);

        repo.deleteById(customer.getId());

        cust = repo.findById(customer.getId());

        assertFalse(cust.isPresent());
    }

    @Test
    public void findCustomerById(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("California");
        customer.setCountry("United States");
        customer.setPostalCode("12345");

        customer = repo.save(customer);

        // Act
        Optional<Customer> cust = repo.findById(customer.getId());

        assertEquals(cust.get(), customer);
    }

    @Test
    public void findAllCustomersByState(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("California");
        customer.setCountry("United States");
        customer.setPostalCode("12345");

        customer = repo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Anakin");
        customer2.setLastName("Skywalker");
        customer2.setEmail("Skyguy@gmail.com");
        customer2.setCompany("Cartoon Network");
        customer2.setPhoneNumber("000-000-0000");
        customer2.setAddress1("12345 Coruscant BLVD");
        customer2.setAddress2("N/A");
        customer2.setCity("San Jose");
        customer2.setState("California");
        customer2.setCountry("United States");
        customer2.setPostalCode("01234");

        customer2 = repo.save(customer2);

        // Act
        List<Customer> customerList = repo.findAllByState("California");

        // Assert
        assertEquals(customerList.size(), 2);
    }

}