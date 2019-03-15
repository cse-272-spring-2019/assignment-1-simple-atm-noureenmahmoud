/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 *
 * @author Cherine
 */
public class Main_Menu_GUI implements ActionListener 
{

    JPanel panel;
    JTextField balance;
    JButton Buttons[];
    String button_names[] = {"Withdraw", "Deposit", "Balance Inquiry", "Previous", "Next", "Exit"};
    JPanel panel_1;
   
    
    Account acc;
    Transactions_Gui trans;
    
    private int counter = 0;

    public Main_Menu_GUI(Account acc) 
    {
        this.acc = acc;
    }

    void Gui() 
    {
        panel = new JPanel();
        Buttons = new JButton[6];
        balance = new JTextField();
        panel_1 = new JPanel();
        GridLayout grid = new GridLayout(2, 3);
        BorderLayout border = new BorderLayout(); 
        
        panel_1.setLayout(grid);
        panel.setLayout(border);
        panel.add("North", balance);

        for (int i = 0; i < 6; i++) 
        {
            Buttons[i] = new JButton(button_names[i]);
            Buttons[i].addActionListener(this);
            panel_1.add(Buttons[i]);
        }

        panel.add("Center", panel_1);
        
        JFrame frame = new JFrame("ATM");

        frame.setContentPane(panel);
        frame.setSize(400,200);
       // frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        
        // withdraw
        if (src == Buttons[0]) 
        {
            trans = new Transactions_Gui(acc, true);
            trans.tran();
        }
        
        //deposit
        if (src == Buttons[1]) 
        {
            trans = new Transactions_Gui(acc, false);
            trans.tran();
        }
        
        //balance
        if (src == Buttons[2]) 
        {
            balance.setText(Float.toString(acc.getBalance()));
        }
        
        //previous
        if (src == Buttons[3]) 
        {
            int array_size = acc.getHistory().size();
            if (counter == array_size) 
            {
                counter -= 1;
            }
            if (acc.getHistory().isEmpty())
            {
                return;
            }
            counter++;
            balance.setText(acc.getHistory().get(array_size - counter));
            System.out.println("Counter " + counter + " " + array_size);
        }
        
        //next
        if (src == Buttons[4]) 
        {
            int array_size = acc.getHistory().size();

            if (acc.getHistory().isEmpty())
            {
                balance.setText(Float.toString(acc.getBalance()));
            }
            else if (counter == 1 || counter==0)
            {
                balance.setText(Float.toString(acc.getBalance()));
                counter=0;
            } 
            else 
            {
                counter--;
                balance.setText(acc.getHistory().get(array_size - counter));
                System.out.println("Counter " + counter + " " + array_size);
            }
        }
        
        //exist program
        if (src == Buttons [5])
        {
             System.exit(0);
        }
    }   

}
