/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Interface.IState;

/**
 *
 * @author OEM
 */
public class AccountState implements IState{
    public final boolean canSetWithDrawalLimit = true;
    public final boolean checkWithDrawalLimit = true;
}
