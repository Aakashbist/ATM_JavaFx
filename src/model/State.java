/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.IState;
import Enum.AccountTypes;


public class State {
  private  AccountTypes accountTypes;
  private IState iState;

    public State(AccountTypes accountTypes, IState iState) {
        this.accountTypes = accountTypes;
        this.iState = iState;
    }

 
    public AccountTypes getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountTypes accountTypes) {
        this.accountTypes = accountTypes;
    }

    public IState getiState() {
        return iState;
    }

    public void setiState(IState iState) {
        this.iState = iState;
    }
    
}
