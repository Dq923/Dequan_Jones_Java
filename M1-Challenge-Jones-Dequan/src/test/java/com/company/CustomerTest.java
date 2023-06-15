package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1,"John",1000, "06-15-2023");
    }

    @Test
    void getBalance() {
        // First case should return the only value within the list of charges
        assertEquals(1000, customer.getBalance()); // Balance = 1000

        // Second Case is when the Balance is increased
        customer.addCharge(1000,"06-18-2023"); // Balance = 2000
        assertEquals(2000, customer.getBalance());

        // Third Case is when the balance is decreased
        customer.addCharge(-1500,"06-19-2023"); // Balance = 500
        assertEquals(500, customer.getBalance());

        // Final case is when the balance drops below zero
        customer.addCharge(-1000, "06-20-2023");// Balance = -500
        assertEquals(-500,  customer.getBalance());

    }

    @Test
    void testToString() {
        assertEquals("\nID: 1\nNAME: John\nBALANCE: $1000",customer.toString());
    }
}