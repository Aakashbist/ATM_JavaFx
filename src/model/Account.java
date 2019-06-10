/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.IATMOperation;

/**
 *
 * @author OEM
 */
public abstract class Account implements IATMOperation {

    protected double accountBalance;
    protected double dailyWithdrawalLimit;

    public abstract void calculateInterest();

    public double getAccountBalance() {
        System.out.println("amount is" + accountBalance);
        return accountBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (checkNotes(amount)) {
            if (hasEnoughFund(amount)) {
                System.out.println("\nyou withdraw " + amount + " from this account ");
                accountBalance -= amount;
                return true;
            } else {
                System.out.println("\nyou exceed daily withdrawl limit ");
                return false;

            }
        } else {
            System.out.println("\nyour withdrawal " + amount + " is not valid");
            return false;
        }

    }

    @Override
    public boolean deposit(double amount) {
        if (checkNotes(amount)) {
            accountBalance += amount;
            System.out.println("\nyou deposit " + amount + " to this account ");
            return true;
        } else {
            System.out.println("\nyou deposit " + amount + " is not valid");
            return false;
        }

    }

    @Override
    public boolean hasEnoughFund(double amount) {
        return accountBalance >= amount;

    }

    @Override
    public boolean checkNotes(double amount) {
        if ((((amount % 100) % 50) % 20) == 0) {
            return true;
        }
        return false;
    }
}
