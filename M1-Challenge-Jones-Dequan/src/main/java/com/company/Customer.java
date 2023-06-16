package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Customer(){
        this.id = 0;
        this.name = "";
    }
    Customer(int ident, String name, int charge, String date){
        this.id = ident;
        this.name = name;
        // add the new charge
        this.addCharge(charge, date);
    }

    public int getBalance() {
        //create a list of all charges using streams
        List<Integer> all_charges = charges.stream()
                .map(AccountRecord::getCharge)
                .collect(Collectors.toList());

        int balance = all_charges.stream() // sum all charges
                .reduce(0,(total,next)-> total+next);

        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return "\nID: " + getId() + "\nNAME: " + getName() + "\nBALANCE: $" + getBalance();
    }

    // I noticed a lot of repeated code, so I included a new method for adding charges
    public void addCharge(int val, String day){// creates an AccountRecord obj to add a new charge/charge date
        AccountRecord newCharge = new AccountRecord();
        newCharge.setCharge(val);
        newCharge.setChargeDate(day);
        this.getCharges().add(newCharge); // add the new charge to the List<AccountRecord>
    }
}
