package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMVC;

    private ObjectMapper mapper = new ObjectMapper();


    @MockBean
    CustomerRepository repo;

    @BeforeEach
    void setUp(){
        repo.deleteAll();/*

        */
    }

    @Test
    public void shouldAddACustomerOnPostRequest() throws Exception{
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
        customer.setState("CA");
        customer.setCountry("United States");
        customer.setPostalCode("12345");
        customer.setId(1);

        String inputJson = mapper.writeValueAsString(customer);

        // Act
        mockMVC.perform(
                post("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
        // Assert
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnAllCustomers() throws Exception{
        // arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("CA");
        customer.setCountry("United States");
        customer.setPostalCode("12345");
        customer.setId(1);

        repo.save(customer); // save customer

        mockMVC.perform(get("/customers")) // act, assert
                        .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateACustomerRecord() throws Exception {
        // arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("CA");
        customer.setCountry("United States");
        customer.setPostalCode("12345");
        customer.setId(1);

        // convert to Json
        String inputJson = mapper.writeValueAsString(customer);

        // Assert
        mockMVC.perform(put("/customers")
               .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteACustomerById() throws Exception{
        // arrange
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("CA");
        customer.setCountry("United States");
        customer.setPostalCode("12345");
        customer.setId(1);

        repo.save(customer); // save customer

        mockMVC.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnCustomersByState() throws Exception{
        // customer1
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Test");
        customer.setEmail("JohnnyTest@gmail.com");
        customer.setCompany("Cartoon Network");
        customer.setPhoneNumber("123-456-7890");
        customer.setAddress1("12345 Main Street");
        customer.setAddress2("N/A");
        customer.setCity("Porkbelly");
        customer.setState("CA");
        customer.setCountry("United States");
        customer.setPostalCode("12345");
        customer.setId(1);

        // customer2
        Customer customer2 = new Customer();
        customer2.setFirstName("Mike");
        customer2.setLastName("Williams");
        customer2.setEmail("JohnnyTest@gmail.com");
        customer2.setCompany("Cartoon Network");
        customer2.setPhoneNumber("000-111-0000");
        customer2.setAddress1("12345 Not Main Street");
        customer2.setAddress2("N/A");
        customer2.setCity("San Jose");
        customer2.setState("CA");
        customer2.setCountry("United States");
        customer2.setPostalCode("01234");
        customer2.setId(2);

        // Act, Assert
        mockMVC.perform(get("/customers/state/ca"))
                .andDo(print())
                .andExpect(status().isOk());


    }




}