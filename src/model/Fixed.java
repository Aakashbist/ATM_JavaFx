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
public class Fixed extends Account {

    private final int FIXED_TIME_FOR_INTEREST = 7;//if withdraw before 7 months

    public Fixed() {
        accountBalance = 00.00;

    }

    @Override
    public void calculateInterest() {
        if (hasMetFixedTermBeforeWithdraw(7)) {
            accountBalance += accountBalance * ((15.00 / 100.00) / 6.0);//15% is per annum interest rate and will calculated half yearly
            System.out.println("\nNew balance after interest is " + accountBalance);
        }
    }
    public boolean hasMetFixedTermBeforeWithdraw(int months) {
        return months >= FIXED_TIME_FOR_INTEREST;
    }

   

}
