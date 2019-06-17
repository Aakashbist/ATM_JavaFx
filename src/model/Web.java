/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.IOperation;

/**
 *
 * @author OEM
 */
public class Web implements IOperation {

    private Account account;
    private Customer customer;

    @Override
    public void showMenu() {
        System.out.println("\t Saving\n ");
        System.out.println("\t Cheque\n ");
        System.out.println("\t NetSaver\n ");
        System.out.println("\t Fixed\n ");
    }

    @Override
    public void getBalance() {

        System.out.println("Initilezed prefer account to get balance.\n"
                + " reference variable of parent class cannot access method of child class");
    }

    @Override
    public int getCustomerDetails() {
      return  customer.getClientId();
    }

    public boolean transfer(Account account, Account toAccount) {
        return true;
    }

    @Override
    public boolean logIn(int clientId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean logIn(int pin, int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean logOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
