/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.IOperation;
import Interface.ICustomerFactory;

/**
 *
 * @author OEM
 */
public class ATM implements IOperation {

    private int id;
    private String location;
    public Account currentAccount;
    private Customer customer;
    private ICustomerFactory customerFactory;

    public ATM(ICustomerFactory customerFactory) {
        this.customerFactory = customerFactory;

    }

    public int getAtmId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void showMenu() {
        System.out.println("\t Saving\n ");
        System.out.println("\t Cheque\n ");
        System.out.println("\t NetSaver\n ");
        System.out.println("\t Fixed\n ");

    }

    @Override
    public void getBalance() {

    }

    @Override
    public boolean logIn(int clientId, String password) {
        Customer customer = customerFactory.getById(clientId);
        if (customer != null) {
            if (customer.getPassword().equals(password)) {
                this.customer = customer;
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean logIn(int pin, int clientId) {
        Customer customer = customerFactory.getById(clientId);
        if (customer != null) {
            if (customer.getPin() == pin) {
                this.customer = customer;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean logOut() {
        return true;
    }

    @Override
    public int getCustomerDetails() {
        return customer.getClientId();
    }

}
