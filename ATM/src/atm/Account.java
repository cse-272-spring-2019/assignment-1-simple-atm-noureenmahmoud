

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Cherine
 */
public class Account implements ATM_Interface
{

    private int account_number;
    private int pin;
    private float balance = 0;
    private String name;
    private static  int ACCOUNT_NUMBER = 5810;
    private static  int PIN = 1234;
    private boolean valid_account = false;
    private ArrayList<String> History = new ArrayList<String>();
    private JPanel panel= new JPanel();
    
    
    public Account(int account_number, int pin)
    {
        this.account_number = account_number;
        this.pin = pin;
    }
    

    public void account_check() 
    {
      
        if (account_number != ACCOUNT_NUMBER) 
        {
            valid_account = false;
        } 
        else 
        {
            valid_account = true;
            
              if (pin != PIN) 
            {
               valid_account = false;
            }
              else 
            {
               valid_account = true;
            }  
        }
    }

    public void Deposit(float amount) 
    {
        if (valid_account) 
        {
            balance += amount;
            History.add("Deposit "+ amount);
            System.out.println("Deposited "+ amount);
        }
    }

    public void Withdraw(float amount) 
    {
        if (valid_account)
        {
            if (amount > balance)
            {
                JOptionPane.showMessageDialog(panel, "ERROR: No Enough Money");
            }
            else
            {
                balance -= amount;
                History.add("Withdraw "+ amount);
                System.out.println("Withdrawn "+ amount);
            }
        }
    }

    public float getBalance() {
        return balance;
    }

    public boolean isValid_account() {
        return valid_account;
    }

    public ArrayList<String> getHistory() {
        return History;
    }
    
}
