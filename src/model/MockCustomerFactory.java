/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.ICustomerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author OEM
 */
public class MockCustomerFactory implements ICustomerFactory {

    private List<Customer> customers = new ArrayList<>();
 

    public MockCustomerFactory() {
        Customer customer=createCustomer("Aakash", "Sydney", "dontknow");
        
        System.out.println("User created with customer id is  "+customer.getClientId());
    }

    @Override
    public Customer getById(int id) {
        for (Customer customer : customers) {
            if (customer.getClientId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer createCustomer(String name, String address, String dateOfBirth) {
        Customer customer = new Customer(name, address, dateOfBirth);
        customer.setClientId(newId());
        customer.setPassword("12345");
        customer.setPin(5544);
        customers.add(customer);
               return customer;
    }

   
    
    private int newId() {
        Random random = new Random();
        int id = random.nextInt(1)+100;
        boolean matched = false;

        for (Customer customer : customers) {
            if (customer.getClientId() == id) {
                matched = true;
            }
        }
        if (matched) {
            return newId();
        }
        return id;
    }

}
