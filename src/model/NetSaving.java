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
public class NetSaving extends Account {

    private double dailywithdraw;

    public NetSaving() {
        accountBalance = 00.00;
        dailyWithdrawalLimit = 100.00;

    }

    @Override
    public void calculateInterest() {
        accountBalance += accountBalance * ((20.00 / 100.00) / 12.00);//20 is per annum interest rate
        System.out.println("\nNew balance after interest is " + accountBalance);
    }

    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (hasEnoughFund(amount)) {
            if (amount < dailyWithdrawalLimit) {
                return super.withdraw(amount);

            } else {
                System.out.println("\nyou exceed daily withdrawl limit ");
                return false;
            }
        }
        return false;
    }

}
