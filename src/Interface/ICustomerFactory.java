/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import model.Customer;

/**
 *
 * @author OEM
 */
public interface ICustomerFactory {
    public Customer getById(int id);
    public Customer createCustomer(String name, String address,String dateOfBirth);
   }
