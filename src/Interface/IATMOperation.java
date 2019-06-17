/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author OEM
 */
public interface IATMOperation {

    boolean withdraw(double amount);

    boolean deposit(double amount);

    boolean hasEnoughFund(double amount);

    boolean checkNotes(double amount);
}
