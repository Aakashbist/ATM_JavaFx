/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author OEM
 */
public class Cheque extends Account {

    public Cheque() {
        accountBalance = 00.00;

    }

    

    @Override
    public void calculateInterest() {
        double interest = 0.00;
        System.out.println("\nno interest in cheque account\n");

    }


}
