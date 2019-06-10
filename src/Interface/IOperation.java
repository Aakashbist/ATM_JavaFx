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
public interface IOperation {

    public void showMenu();

    public boolean logIn(int clientId, String password);

    public boolean logIn(int pin, int clientId);

    public boolean logOut();

    public void getBalance();

    public int getCustomerDetails();
}
