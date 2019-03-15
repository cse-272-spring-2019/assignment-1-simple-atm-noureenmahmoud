/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;

/**
 *
 * @author Cherine
 */
public interface ATM_Interface {
     public void account_check();
     public void Deposit(float amount);
     public void Withdraw(float amount); 
     public float getBalance();
     
}
