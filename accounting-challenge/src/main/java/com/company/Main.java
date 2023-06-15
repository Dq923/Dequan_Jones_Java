package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this

        List<Customer> customerList = new ArrayList<Customer>();
        /* Potential outer loop for customer data
        for(String[] customerDatum : customerData){

        }
        */
        // These nested loops and conditionals are to set up the List<Customer>
        for (String[] customerDatum : customerData) { // outer loop to go through all String[] customer data
            boolean exists = false; // Does the customer already exist?

            // Need a variable to represent each index of string[]
            int id = Integer.parseInt(customerDatum[0]), charge = Integer.parseInt(customerDatum[2]);
            String name = customerDatum[1], date = customerDatum[3];

            for (Customer customer : customerList) {   // inner loop to check if current customer already exists
                if (id == customer.getId()) {
                    exists = true;

                    // Create a new charge and add it to the list of charges
                    customer.addCharge(charge, date);
                }
            }
            if (!exists) { // if the customer does not yet exist in the List, add them
                customerList.add(new Customer(id, name, charge, date));
            }
        }

        // Print all customers listed
        customerList.stream()
                        .forEach(customer -> System.out.println(customer.toString()));


        // Printing all positve accounts
        System.out.println("\nPositive accounts:");
        List<Customer> positiveAccounts = customerList.stream()
                        .filter(cust ->cust.getBalance() > 0)
                                .collect(Collectors.toList());

        positiveAccounts.stream().forEach(System.out::println);


        // Printing all negative accounts
        System.out.println("\nNegative accounts:");
        List<Customer> negativeAccounts = customerList.stream()
                .filter(cust -> cust.getBalance() < 0)
                .collect(Collectors.toList());

        negativeAccounts.stream().forEach(System.out::println);

    }
}
