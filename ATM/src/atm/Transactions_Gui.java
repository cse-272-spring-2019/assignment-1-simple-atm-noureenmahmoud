/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Cherine
 */
public class Transactions_Gui implements ActionListener 
{

    private JPanel panel;
    private JTextField balance;
    private JButton Buttons[];
    private JPanel panel_1;
    private Account acc;
    
    
    String amount;
    boolean withdraw;
    JFrame frame;

    public Transactions_Gui(Account acc, boolean withdraw)
    {
        this.acc = acc;
        this.withdraw = withdraw;
    }

    void tran() 
    {
        panel = new JPanel();
        Buttons = new JButton[12];
        balance = new JTextField();
        panel_1 = new JPanel();
        amount = new String();
        GridLayout grid = new GridLayout(4, 3);
        BorderLayout border = new BorderLayout();
        
        panel_1.setLayout(grid);
        panel.setLayout(border);
        panel.add("North", balance);

        
        
        for (int i = 1; i < 10; i++)
        {
            Buttons[i] = new JButton(String.valueOf(i));
            Buttons[i].addActionListener(this);
            panel_1.add(Buttons[i]);
        }
        
        Buttons[10] = new JButton(String.valueOf("Clear"));
        Buttons[10].addActionListener(this);
        panel_1.add(Buttons[10]);

        Buttons[0] = new JButton(String.valueOf(0));
        Buttons[0].addActionListener(this);
        panel_1.add("South", Buttons[0]);

        Buttons[11] = new JButton(String.valueOf("OK"));
        Buttons[11].addActionListener(this);
        panel_1.add("South", Buttons[11]);
       
        
        
        panel.add("Center", panel_1);

        frame = new JFrame("ATM_Transaction");

        frame.setContentPane(panel);
        frame.setSize(400,200);
        //frame.pack();
        frame.setVisible(true);
    }

    void DONE()
    {
        if (amount.isEmpty()) 
        {
            JOptionPane.showMessageDialog(panel, "Please Enter amount");
            return;
        }
        
        if (withdraw) 
        {
            acc.Withdraw(Integer.parseInt(amount));
        }
        
        else 
        {
            //Deposit
            acc.Deposit(Integer.parseInt(amount));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Object src = evt.getSource();
        //loop to check input from 0-9
        for (int i = 1; i < 10; i++) 
        {
            if (src == Buttons[i]) 
            {
                amount = amount + String.valueOf(i);
                balance.setText(amount);               
            }
        }
        
        if (src == Buttons[10])
        {
            amount="";
            balance.setText("");
        }
        
        
        if (src == Buttons[0])
        {
            amount = amount + "0";
            balance.setText(amount);
        } 
        
        
        if (src == Buttons[11]) 
        {
            DONE();
            frame.dispose();
        }
    }

}
