/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.Iwithdrawal;

/**
 *
 * @author OEM
 */
public class Saving extends Account implements Iwithdrawal {

    private double dailywithdraw;
  private double dailyWithdrawalLimit = 100.00;
    public Saving() {
        accountBalance = 100.00;
       

    }

    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

  

    public void SetWithdrawalLimit(double amount) {
        this.dailyWithdrawalLimit = amount;
    }

    @Override
    public void calculateInterest() {
        double interest = (10.00 / 100.00) / 365.00;
        accountBalance += accountBalance * interest;//10 is per annum interest rate
        System.out.println("\nNew balance after interest is " + accountBalance);
    }

    @Override
    public double changeWithdralLimit(double amount) {
        SetWithdrawalLimit(amount);
        return getDailyWithdrawalLimit();
    }

    @Override
    public boolean withdraw(double amount) {
        if (hasEnoughFund(amount)) {
            if (amount < dailyWithdrawalLimit) {
                   System.out.println("daily withdraw: "+ dailywithdraw);
              return super.withdraw(amount);
               
            } else {
                System.out.println("\nyou exceed daily withdrawl limit ");
                return false;
            }
        }
        return false;
    }



}
